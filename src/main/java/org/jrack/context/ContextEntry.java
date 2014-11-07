package org.jrack.context;

import java.util.Map;

public class ContextEntry<T> implements Map.Entry<String, T> {
    private final String key;
    private T value;

    public ContextEntry(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public ContextEntry(Map.Entry<String, T> entry) {
        this(entry.getKey(), entry.getValue());
    }

    @Override public String getKey() {
        return key;
    }

    @Override public T getValue() {
        return value;
    }

    @Override public T setValue(T value) {
        T ret = this.value;
        this.value = value;
        return ret;
    }

    public String toString() {
        return key + "=" + value;
    }
}
