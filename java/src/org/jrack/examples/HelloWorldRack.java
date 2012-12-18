package org.jrack.examples;

import org.jrack.JRack;
import org.jrack.RackResponse;
import org.jrack.RackResponseUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class HelloWorldRack implements JRack {
    public RackResponse call(Map<String, Object> input) {
        return RackResponseUtils.standardHtml("Hello World");
    }
}
