package org.jrack.context;

import org.jrack.Context;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * imported from https://github.com/rack4java/rack4java and replaced the
 * implementation to use the ConcurrentHashMap instead
 */
public class MapContext<T> implements Context<T> {
    protected Map<String, Object> map;

    public MapContext(Map<String, Object> map) {
        this.map = map;
    }

    public MapContext() {
        this(new ConcurrentHashMap<String, Object>());
    }

    @Override
    public Object getObject(String key) {
        return map.get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(String key) {
        return (T) map.get(key);
    }

    @Override
    public Context<T> with(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public MapContext<T> with(Context<String> context) {
        for (Map.Entry<String, Object> entry : context) {
            with(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    @Override
    public Object remove(String key) {
        return map.remove(key);
    }

    @Override
    public Iterator<Map.Entry<String, Object>> iterator() {
        return map.entrySet().iterator();
    }
}
