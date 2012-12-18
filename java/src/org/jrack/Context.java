package org.jrack;

import java.util.Map;

/**
 * imported from https://github.com/rack4java/rack4java
 */
public interface Context<T> extends Iterable<Map.Entry<String, Object>> {
    Object getObject(String key);

    T get(String key);

    Context<T> with(String key, Object value);

    Object remove(String key);
}