package org.jrack.context;

public class LiteralContext<T> extends MapContext<T> {
    public LiteralContext(Object... objects) {
        if (objects.length % 2 != 0) throw new IllegalArgumentException("LiteralContext requires an even number of args");
        for (int i = 0; i < objects.length; i += 2) {
            with((String)objects[i], objects[i+1]);
        }
    }
}