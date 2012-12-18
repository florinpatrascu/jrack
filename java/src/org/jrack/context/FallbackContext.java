package org.jrack.context;


import org.jrack.Context;

import java.util.Iterator;
import java.util.Map;

public class FallbackContext<T> implements Context<T> {
    private Context<T>[] list;

    public FallbackContext(Context<T>... list) {
        this.list = list;
    }

    @Override public T get(String key) {
        for (Context<? extends T> context : list) {
            T ret = context.get(key);
            if (null != ret) return ret;
        }
        return null;
    }

    @Override public Iterator<Map.Entry<String,Object>> iterator() {
        return new CascadeIterator<Map.Entry<String,Object>>(list);
    }

    @Override public Context<T> with(String key, Object value) {
        list[0].with(key, value);
        return this;
    }

    @Override public Object remove(String key) {
        return list[0].remove(key);
    }

    @Override public Object getObject(String key) {
        // TODO Auto-generated method stub
        return null;
    }
}