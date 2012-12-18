package org.jrack;

import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.Map;

public class RackResponse {
    public static final String DEFAULT_ENCODING = "utf-8";

    private String response;
    private final Map<String, String> headers;
    private int status;


    public RackResponse(int status, Map<String, String> headers, String response) {
        this.status = status;
        this.headers = headers;
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getStatus() {
        return status;
    }
}
