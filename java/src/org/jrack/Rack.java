package org.jrack;

/**
 * The interface implemented by all Rack4java applications
 * <p/>
 * <p>This interface is deliberately minimal so that it is very simple to implement.</p>
 * <p/>
 * <p>An example of a "Hello World" Rack4java application might be:
 * <pre>
 * public class HelloWorld implements Rack {
 *     public RackResponse call(Map<String, Object> input) {
 *         return new RackResponse(200,
 *              "Hello World",
 *              "Content-Type", "text/plain");
 *     }
 * }
 * </pre></p>
 *
 * <p>For more examples, see <i><a href="http://github.com/rack4java/rack4java-examples/">The Rack4Java-Examples project</a></i></p>
 *
 * <p>A Rack4Java application just needs to implement a single method "call".
 * This method will be invoked for every incoming request, passing in a map of named values representing
 * the details of the request. The may will also probably contain other values representing the context
 * of the request. As far as possible, Rack4Java uses the same names for these parameters as
 * <a href="http://rack.rubyforge.org/doc/SPEC.html">the original Ruby Rack project</a>.</p>
 *
 * <p>The return value from the "call" method is a {@link RackResponse} object. RackResponse provides a
 * variety of constructors for different types of page body (String, byte[], file) and different
 * combinations of headers. They are all interchangeable
 *
 * @author Frank Carver
 * @see org.jrack.RackResponse
 */
public interface Rack {
    public static final String EMPTY_STRING = "";
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public static final String REQUEST_METHOD = "REQUEST_METHOD";
    public static final String SCRIPT_NAME = "SCRIPT_NAME";
    public static final String PATH_INFO = "PATH_INFO";
    public static final String QUERY_STRING = "QUERY_STRING";
    public static final String SERVER_NAME = "SERVER_NAME";
    public static final String SERVER_PORT = "SERVER_PORT";

    public static final String MESSAGE_STATUS = "MESSAGE_STATUS";
    public static final String MESSAGE_BODY = "MESSAGE_BODY";

    public static final String HTTP_ = "HTTP_";
    public static final String HTTP_USER_AGENT = HTTP_ + "User-Agent";
    public static final String HTTP_HOST = HTTP_ + "Host";
    public static final String HTTP_CONNECTION = HTTP_ + "Connection";
    public static final String HTTP_ACCEPT = HTTP_ + "Accept";
    public static final String HTTP_ACCEPT_CHARSET = HTTP_ + "Accept-Charset";
    public static final String HTTP_ACCEPT_ENCODING = HTTP_ + "Accept-Encoding";
    public static final String HTTP_CONTENT_LENGTH = HTTP_ + "Content-Length";
    public static final String HTTP_CONTENT_TYPE = HTTP_ + "Content-Type";

    public static final String REQUEST = "SERVLET_REQUEST";
    public static final String RESPONSE = "SERVLET_RESPONSE";
    public static final String COOKIES = "COOKIES";

    public static final String RACK_SESSION = "rack.session";
    public static final String RACK_VERSION = "rack.version";
    public static final String RACK_URL_SCHEME = "url_scheme";
    public static final String RACK_INPUT = "rack.input";
    public static final String RACK_ERRORS = "rack.errors";
    public static final String RACK_MULTITHREAD = "rack.multithread";
    public static final String RACK_MULTIPROCESS = "rack.multiprocess";
    public static final String RACK_RUN_ONCE = "rack.run_once";
    public static final String RACK_LOGGER = "rack.logger";

    /**
     * The single method implemented by all Rack4Java applications
     *
     * @param environment a lightweight "map" of named values combining both the server
     *                    environment and the HTTP request.
     * @return a RackResponse object with status code, headers and either a String, byte[] or File payload.
     */
    Context<String> call(Context<String> environment) throws Exception;
}
