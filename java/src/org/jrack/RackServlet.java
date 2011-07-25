package org.jrack;

import org.jrack.utils.ClassUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RackServlet extends HttpServlet {
    protected static final Logger log = LoggerFactory.getLogger(RackServlet.class);
    private JRack rack;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //todo add .ru support and proper initialization
        String rackClass = config.getInitParameter("rack");

        try {

            setRack((JRack) ClassUtilities.loadClass(rackClass).newInstance());

        } catch (Exception e) {
            throw new ServletException("Cannot load: " + rackClass);
        }

        log.info(String.format("%s; active ....", rackClass));
    }

    /**
     * used by servlet container
     */
    public RackServlet() {
    }

    private void processCall(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            RackResponse response = rack.call(getEnvironment(req));
            writeResponse(resp, response);
        } catch (Exception e) {
            RackServlet.throwAsError(e);
        }
    }

    private void writeResponse(HttpServletResponse resp, RackResponse response) throws IOException {
        resp.setStatus(response.getStatus());
        for (String key : response.getHeaders().keySet()) {
            resp.setHeader(key, response.getHeaders().get(key));
        }
        resp.getWriter().print(response.getResponse());
    }

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
        return environment;
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        processCall((HttpServletRequest) req, (HttpServletResponse) res);
    }

    public JRack getRack() {
        return rack;
    }

    public void setRack(JRack rack) {
        this.rack = rack;
    }

    public static Error throwAsError(Throwable t) throws Error {
        if (t instanceof RuntimeException) {
            throw (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new Error(t);
        }
    }
}
