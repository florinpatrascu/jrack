package org.jrack;

import org.jrack.context.MapContext;
import org.jrack.logging.JRackLogger;
import org.jrack.logging.Slf4jLogger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

public abstract class JRack implements Rack {
    private static final JRackLogger logger = new Slf4jLogger(RackServlet.class.getName());
    private static final Context<String> commonEnvironment = new MapContext<String>()
            .with(Rack.RACK_VERSION, Arrays.asList(0, 1))
            .with(Rack.RACK_ERRORS, System.err)
            .with(Rack.RACK_MULTITHREAD, true)
            .with(Rack.RACK_MULTIPROCESS, true)
            .with(Rack.RACK_RUN_ONCE, false)
            .with(Rack.RACK_LOGGER, logger);

    public Object init(Object config) throws Exception {
        return null;
    }

    public abstract RackResponse call(Context<String> environment) throws Exception;

    public Context<String> getEnvironment(HttpServletRequest req) {
        @SuppressWarnings("unchecked") Context<String> environment = new MapContext<String>()
                .with(commonEnvironment);

        environment.with(Rack.REQUEST_METHOD, req.getMethod());
        environment.with(Rack.PATH_INFO, req.getPathInfo());
        environment.with(Rack.QUERY_STRING, req.getQueryString());
        environment.with(Rack.SERVER_NAME, req.getServerName());
        environment.with(Rack.SERVER_PORT, req.getServerPort());
        environment.with(Rack.SCRIPT_NAME, req.getServletPath());
        environment.with(Rack.REQUEST, req);
        environment.with(Rack.COOKIES, req.getCookies());

        @SuppressWarnings("unchecked") Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            environment.with(Rack.HTTP_ + header, req.getHeader(header));
        }

        environment.with(Rack.RACK_URL_SCHEME, req.getScheme());
        try {
            environment.with(Rack.RACK_INPUT, req.getInputStream());
        } catch (IOException e) {
            environment.with(Rack.RACK_INPUT, null);
        }

        return environment;
    }
}
