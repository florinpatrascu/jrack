package org.jrack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jrack.context.MapContext;
import org.jrack.logging.JRackLogger;
import org.jrack.logging.Slf4jLogger;
import org.jrack.utils.StringUtils;

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
        final String servletPath = StringUtils.stringValue(req.getServletPath(), JRack.EMPTY_STRING);
        // better not confusing the Rack client.
        // String pathInfo = StringUtils.stringValue( req.getPathInfo(), req.getServletPath());
        // we'll make it EMPTY, as a convenience
        String pathInfo = StringUtils.stringValue(req.getPathInfo(), JRack.EMPTY_STRING);

        environment.with(Rack.PATH_INFO, pathInfo);
        environment.with(Rack.QUERY_STRING, req.getQueryString());
        environment.with(Rack.SERVER_NAME, req.getServerName());
        environment.with(Rack.SERVER_PORT, req.getServerPort());
        environment.with(Rack.SCRIPT_NAME, servletPath);
        environment.with(Rack.REQUEST, req);

        try {
            environment.with(Rack.RACK_INPUT, req.getInputStream());
        } catch (IOException e) {
            environment.with(Rack.RACK_INPUT, null);
        }

        environment.with(Rack.PARAMS, modifiableRequestParameterMap(req.getParameterMap()));
        environment.with(Rack.RACK_BROWSER_LOCALE, req.getLocale());
        environment.with(Rack.COOKIES, req.getCookies());

        @SuppressWarnings("unchecked") Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            environment.with(Rack.HTTP_ + header, req.getHeader(header));
        }

        environment.with(Rack.RACK_URL_SCHEME, req.getScheme());

        return environment;
    }

    /**
     * create a new modifiable parameter map that can be updated by the client if need be
     *
     * @param parameterMap the request parameters map
     * @return a new Map<String, String[]> map or null if the parameterMap is empty or null
     */
    private Map<String, String[]> modifiableRequestParameterMap(Map parameterMap) {
        Map<String, String[]> map = null;
        if (parameterMap != null && !parameterMap.isEmpty()) {
            map = new HashMap<String, String[]>();
            map.putAll(parameterMap);
        }
        return map;
    }
}
