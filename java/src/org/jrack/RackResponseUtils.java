package org.jrack;

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

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=utf-8";

    public static RackResponse standardHtml(String html) {
        return new RackResponse(RackResponseUtils.ReturnCode.OK, getStandardHtmlHeader(), html);
    }

    private static Map<String, String> getStandardHtmlHeader() {
        return Collections.singletonMap(CONTENT_TYPE, CONTENT_TYPE_TEXT_HTML);
    }
}
