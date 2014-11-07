package org.jrack.examples;

import org.jrack.Context;
import org.jrack.JRack;
import org.jrack.RackResponse;
import org.jrack.RackResponseUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class HelloWorldRack extends JRack {
    public RackResponse call(Context<String> input) {
        return RackResponseUtils.standardHtml("Hello World! w⦿‿⦿t!");
    }
}
