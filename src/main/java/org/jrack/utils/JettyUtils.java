package org.jrack.utils;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.jrack.JRack;
import org.jrack.RackServlet;
import org.jrack.examples.EchoRack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple support for running a Jetty servlet instance
 *
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 11-07-30 4:10 PM)
 */
public class JettyUtils {
    protected static final Logger log = LoggerFactory.getLogger(JettyUtils.class);
    public static final String DEFAULT_SERVER_ADDRESS = "127.0.0.1";
    public static int DEFAULT_MAX_THREADS = 20;

    public static void start(String host, int port, JRack rack) {
        startJettyServer(host, port, new RackServlet(rack));
        log.info(String.format("Jetty rack listening on: %s:%d", host, port));
    }

    /**
     * start a simple Jetty server
     *
     * @param host    host address
     * @param port    the port number
     * @param servlet a rack Servlet
     */
    private static void startJettyServer(String host, int port, RackServlet servlet) {
        // see: http://blog.softwaredemo.com/2014/02/06/embedded-jetty-how-to-upgrade-from-version-6-to-9/ for more hints
        try {
            Server server = new Server(new QueuedThreadPool(DEFAULT_MAX_THREADS));
            ServerConnector connector = new ServerConnector(server);

            connector.setHost(host);
            connector.setPort(port);
            connector.setIdleTimeout(1000 * 60 * 60);
            connector.setSoLingerTime(-1);

            ServletHolder servletHolder = new ServletHolder(servlet);
            //servletHolder.setInitParameter("foo", "bar");

            ServletContextHandler ctxHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
            ctxHandler.setContextPath("/");
            ctxHandler.addServlet(servletHolder, "/echo");

            server.setConnectors(new Connector[] {connector});
            server.setHandler(ctxHandler);
            server.start();
//            server.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * run a simple Jetty servlet and test with:
     * curl http://localhost:8080/echo -d 'hello'
     *
     * @param args cmd args if any
     */
    public static void main(String[] args) {
        start(DEFAULT_SERVER_ADDRESS, 8080, new EchoRack());
    }
}