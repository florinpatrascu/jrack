package org.jrack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jrack.logging.JRackLogger;
import org.jrack.logging.Slf4jLogger;
import org.jrack.utils.ClassUtilities;

public class RackServlet extends HttpServlet {
    private JRackLogger logger = new Slf4jLogger(RackServlet.class.getName());
    private JRack rack;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //todo jrack yaml config file
        String rackClass = config.getInitParameter("rack");
        //todo user logging

        try {
            setRack((JRack) ClassUtilities.loadClass(rackClass).newInstance());
        } catch (Exception e) {
            if (this.rack == null) {
                throw new ServletException("Cannot load the 'rack' implementation: " + rackClass);
            } else {
                rackClass = this.rack.getClass().getCanonicalName();
                logger.log(String.format("this 'rack' is using: %s", rackClass));
            }
        }

        logger.log(String.format("%s; active ....", rackClass));
    }

    /**
     * used by servlet container
     */
    public RackServlet() {
    }

    public RackServlet(JRack rack) {
        this.rack = rack;
    }

    private void processCall(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
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
            if (body != null) {
                if (body.getType() == RackBody.Type.file) {

                    // Copy.copy(new FileInputStream(body.getBodyAsFile()), httpResponse.getOutputStream());
                    // or use NIO?
                    final File file = body.getBodyAsFile();
                    if (file != null) {
                        try (FileInputStream inputStream = new FileInputStream(file)) {
                            inputStream.getChannel()
                                    .transferTo(0, file.length(), Channels.newChannel(httpResponse.getOutputStream()));
                        }
                    }

                } else {
                    httpResponse.setCharacterEncoding(RackResponse.DEFAULT_ENCODING);
                    httpResponse.getOutputStream().write(body.getBytes(RackResponse.DEFAULT_ENCODING));
                }

            } else {
                httpResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }

        } catch (Exception e) {
            RackServlet.throwAsError(e);
        }
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
