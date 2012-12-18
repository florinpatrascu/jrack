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
        if (key != null && map != null && map.containsKey(key)) {
            return map.get(key);
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(String key) {
        if (key != null && map != null && map.containsKey(key)) {
            return (T) map.get(key);
        } else {
            return null;
        }
    }

    @Override
    public Context<T> with(String key, Object value) {
        if (key != null && value != null) {
            map.put(key, value);
        }
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
        Object o = null;
        if (key != null && map != null && map.containsKey(key)) {
            o = map.remove(key);
        }
        return o;
    }

    @Override
    public Iterator<Map.Entry<String, Object>> iterator() {
        return map.entrySet().iterator();
    }
}
