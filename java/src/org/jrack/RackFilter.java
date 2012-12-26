package org.jrack;

import org.jrack.utils.ClassUtilities;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 2012-12-17 7:19 PM)
 */
public class RackFilter implements Filter {

    private FilterConfig filterConfig;
    private ServletContext servletContext;
    private JRack rack;
    /**
     * set of paths that should be ignored
     */
    private final Set<String> ignorePaths = new HashSet<String>();

    /**
     * Filter initialization
     *
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        servletContext = filterConfig.getServletContext();
        String rackClass = filterConfig.getInitParameter("rack");
        String paths = filterConfig.getInitParameter("ignore");

        if (paths != null) {
            String[] parts = paths.split(",");
            for (String path : parts) {
                path = path.trim();
                if (path.startsWith("/")) {
                    path = path.substring(1);
                }
                ignorePaths.add(path);
            }
        }
        try {
            setRack((JRack) ClassUtilities.loadClass(rackClass).newInstance());
            rack.init(filterConfig);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Cannot load: " + rackClass);
        }
    }

    /**
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public final void doFilter(
            ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (shouldIgnorePath(httpRequest)) {
            if (chain != null) {
                chain.doFilter(request, response);
            }
        } else {
            // see Rack specs
            // - http://rack.rubyforge.org/doc/SPEC.html
            try {
                Context<String> resp = rack.call(rack.getEnvironment(httpRequest));
                httpResponse.setStatus((Integer) resp.getObject(Rack.MESSAGE_STATUS));

                for (Map.Entry<String, Object> entry : resp) {
                    if (entry.getKey().startsWith(Rack.HTTP_)) {
                        httpResponse.setHeader(entry.getKey().substring(Rack.HTTP_.length()),
                                (String) entry.getValue());
                    }
                }

                RackBody body = (RackBody) resp.getObject(Rack.MESSAGE_BODY);
                //httpResponse.getWriter().print(rackResponse.getResponse());
                if (body.getType() == RackBody.Type.file) {

                    // Copy.copy(new FileInputStream(body.getBodyAsFile()), httpResponse.getOutputStream());
                    // or use NIO?
                    final File file = body.getBodyAsFile();
                    if (file != null) {
                        final FileInputStream inputStream = new FileInputStream(file);
                        try {
                            inputStream.getChannel()
                                    .transferTo(0, file.length(),
                                            Channels.newChannel(httpResponse.getOutputStream()));
                        } finally {
                            inputStream.close();
                        }
                    }

                } else {
                    response.setCharacterEncoding(RackResponse.DEFAULT_ENCODING);
                    httpResponse.getOutputStream().write(body.getBytes(RackResponse.DEFAULT_ENCODING));
                }

            } catch (Exception e) {
                RackServlet.throwAsError(e);
            }
        }
    }

    /**
     * Filter destroy event interceptor
     */
    public void destroy() {
        this.filterConfig = null;
    }

    /**
     * Filter configuration getter
     *
     * @return FilterConfiguration
     */
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public JRack getRack() {
        return rack;
    }

    public void setRack(JRack rack) {
        this.rack = rack;
    }

    /**
     * Returns a relative path to the filter path and context root from an HttpServletRequest
     */
    public String getRelativePath(HttpServletRequest request) {
        String path = request.getPathInfo();
        if (path == null) {
            path = request.getServletPath();
        }

        if (path.length() > 0) {
            path = path.substring(1);
        }

        return path;
    }

    private boolean shouldIgnorePath(HttpServletRequest request) {
        boolean ignore = false;

        if (ignorePaths.size() > 0) {
            String relativePath = getRelativePath(request);
            if (relativePath != null && relativePath.trim().length() > 0) {
                for (String path : ignorePaths) {
                    if (relativePath.startsWith(path)) {
                        ignore = true;
                        break;
                    }
                }
            }
        }
        return ignore;
    }

    /**
     * todo: refactor
     *
     * @param req the HttpServletRequest
     * @return
     */

}
