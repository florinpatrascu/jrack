package org.jrack.utils;

import org.jrack.JRack;
import org.jrack.RackResponse;
import org.jrack.RackResponseUtils;

import java.util.Arrays;
import java.util.Map;

public class JRackExceptionReporter implements JRack {
    private final JRack rack;
    public static final String ERROR_MESSAGE_HTML = "<html>" +
            "<header>" +
            "    <style type=\"text/css\">" +
            "        body { font-family: Monospace; }" +
            "    </style>" +
            "</header>" +
            "<body>" +
            "An error has occurred<br/>" +
            "Message: %s<br/>" +
            "Error occurred at <br/>" +
            "<pre size=\"-2\">" +
            "%s</pre>" +
            "</body>" +
            "</html>";

    public JRackExceptionReporter(JRack rack) {
        this.rack = rack;

    }

    public RackResponse call(Map<String, Object> environment) throws Exception {
        try {
            return rack.call(environment);

        } catch (Throwable e) {
            return RackResponseUtils.standardHtml(processError(e));
        }
    }

    private String processError(Throwable e) {
        return String.format(ERROR_MESSAGE_HTML, e.getMessage(), Arrays.toString(e.getStackTrace()));

    }
}
