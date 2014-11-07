package org.jrack.context;

import org.jrack.Context;

import java.util.Iterator;
import java.util.Map;

/**
 * a Context useful as a fall-back - all keys map to a single default value
 */
public class DefaultContext<T> implements Context<T> {
    private T value;

    public DefaultContext(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked") @Override public Iterator<Map.Entry<String, Object>> iterator() {
        return EmptyIterator.it;
    }

    @Override public Object getObject(String key) {
        return value;
    }

    @Override public T get(String key) {
        return value;
    }

    @Override public Context<T> with(String key, Object value) {
        throw new UnsupportedOperationException("Cannot add to DefaultContext");
    }

    @Override public Object remove(String key) {
        throw new UnsupportedOperationException("Cannot remove from DefaultContext");
    }

}
