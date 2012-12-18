package org.jrack;

public interface RackEnvironment {
    public static final String PATH_INFO = "PATH_INFO";
    public static final String REQUEST_METHOD = "REQUEST_METHOD";
    public static final String SCRIPT_NAME = "SCRIPT_NAME";
    public static final String QUERY_STRING = "QUERY_STRING";
    public static final String SERVER_NAME = "SERVER_NAME";
    public static final String SERVER_PORT = "SERVER_PORT";
    public static final String HTTP_SERVLET_REQUEST = "HTTP_SERVLET_REQUEST";

    public static final String REQUEST = "HTTP_SERVLET_REQUEST";
    public static final String COOKIES = "COOKIES";
    public static final String SESSION = "HTTP_SERVLET_SESSION";

    public static final String HTTP_USER_AGENT = "HTTP_USER_AGENT";
    public static final String HTTP_HOST = "HTTP_HOST";
    public static final String HTTP_CONNECTION = "HTTP_CONNECTION";
    public static final String HTTP_ACCEPT = "HTTP_ACCEPT";
    public static final String HTTP_ACCEPT_CHARSET = "HTTP_ACCEPT_CHARSET";
    public static final String HTTP_ACCEPT_ENCODING = "HTTP_ACCEPT_ENCODING";
    public static final String REMOTE_ADDR = "REMOTE_ADDR";
    public static final String REMOTE_HOST = "REMOTE_HOST";
    public static final String REMOTE_USER = "REMOTE_USER";
    public static final String REQUEST_PATH = "REQUEST_PATH";
    public static final String REQUEST_URL = "REQUEST_URL";
    public static final String HTTP_KEEP_ALIVE = "HTTP_KEEP_ALIVE";
    public static final String HTTP_VERSION = "HTTP_VERSION";
    public static final String SERVER_PROTOCOL = "SERVER_PROTOCOL";
    public static final String LOGGER = "LOGGER";
}
