package org.jrack;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * toy class, to be refactored
 */
public class RackResponseUtils {
    public static class ReturnCode {
        public static final int OK = 200;
    }

    public static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=utf-8";

    public static RackResponse standardHtml(String body) {
        return new RackResponse(RackResponseUtils.ReturnCode.OK)
                .withContentType(CONTENT_TYPE_TEXT_HTML)
                .withBody(body);
    }
}
