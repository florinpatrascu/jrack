package org.jrack.utils;

import org.jrack.Context;
import org.jrack.JRack;
import org.jrack.Rack;
import org.jrack.RackResponse;

import java.util.HashMap;
import java.util.Map;

public class RackCache extends JRack {
    Map<String, JRack> racks = new HashMap<String, JRack>();
    private Map<String, RackResponse> caches = new HashMap<String, RackResponse>();

    public RackResponse call(Context<String> input) throws Exception {
        String path = input.get(Rack.PATH_INFO);
        RackResponse response = caches.get(path);
        if (response == null) {
            JRack rack = racks.get(path);
            response = rack.call(input);
            caches.put(path, response);
        }
        return response;
    }

    public void add(JRack rack, String string) {
        racks.put(string, rack);
    }
}
