package org.jrack;

import org.jrack.logging.JRackLogger;
import org.jrack.logging.Slf4jLogger;
import org.jrack.utils.ClassUtilities;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 2012-12-17 7:19 PM)
 */
public class RackFilter implements Filter {
    private JRackLogger logger = new Slf4jLogger(RackServlet.class.getName());

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
        } catch (Exception e) {
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
            try {
                writeResponse(httpResponse, rack.call(getEnvironment(httpRequest)));
            } catch (Exception e) {
                RackServlet.throwAsError(e);
            }
        }
    }

    private void writeResponse(HttpServletResponse httpResponse, RackResponse rackResponse) throws IOException {
        httpResponse.setStatus(rackResponse.getStatus());

        for (String key : rackResponse.getHeaders().keySet()) {
            httpResponse.setHeader(key, rackResponse.getHeaders().get(key));
        }

        httpResponse.getWriter().print(rackResponse.getResponse());
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
    private Map<String, Object> getEnvironment(HttpServletRequest req) {
        Map<String, Object> environment = new HashMap<String, Object>();
        environment.put(RackEnvironment.REQUEST_METHOD, req.getMethod());
        environment.put(RackEnvironment.PATH_INFO, req.getPathInfo());
        environment.put(RackEnvironment.QUERY_STRING, req.getQueryString());
        environment.put(RackEnvironment.SERVER_NAME, req.getServerName());
        environment.put(RackEnvironment.SERVER_PORT, req.getServerPort());
        environment.put(RackEnvironment.SCRIPT_NAME, req.getServletPath());

        environment.put(RackEnvironment.HTTP_ACCEPT_ENCODING, req.getHeader("Accept-Encoding"));
        environment.put(RackEnvironment.HTTP_USER_AGENT, req.getHeader("User-Agent"));
        environment.put(RackEnvironment.HTTP_HOST, req.getHeader("Host"));
        environment.put(RackEnvironment.HTTP_CONNECTION, req.getHeader("Connection"));
        environment.put(RackEnvironment.HTTP_ACCEPT, req.getHeader("Accept"));
        environment.put(RackEnvironment.HTTP_ACCEPT_CHARSET, req.getHeader("Accept-Charset"));
        environment.put(RackEnvironment.REMOTE_ADDR, req.getRemoteAddr());
        environment.put(RackEnvironment.REMOTE_HOST, req.getRemoteHost());
        environment.put(RackEnvironment.REMOTE_USER, req.getRemoteUser());
        environment.put(RackEnvironment.REQUEST_PATH, req.getRequestURI());
        environment.put(RackEnvironment.REQUEST_URL, req.getPathTranslated());
        environment.put(RackEnvironment.HTTP_KEEP_ALIVE, req.getHeader("Keep-Alive"));
        environment.put(RackEnvironment.HTTP_VERSION, req.getProtocol());
        environment.put(RackEnvironment.SERVER_PROTOCOL, req.getProtocol());

        environment.put(RackEnvironment.HTTP_SERVLET_REQUEST, req);
        environment.put(RackEnvironment.REQUEST, req); //convenience
        environment.put(RackEnvironment.LOGGER, logger);
        return environment;
    }
}
