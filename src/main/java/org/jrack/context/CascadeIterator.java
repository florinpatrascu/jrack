package org.jrack.context;

import java.util.Iterator;

public class CascadeIterator<T> implements Iterator<T> {

    private Iterable<? extends T>[] iterables;
    private Iterator<? extends T> current;
    private int index;

    public CascadeIterator(Iterable<? extends T>... iterables) {
        this.iterables = iterables;
        this.index = 0;
        current = null;
    }

    @Override public boolean hasNext() {
        while (null == current || !current.hasNext()) {
            if (index >= iterables.length) return false;
            current = iterables[index++].iterator();
        }
        return current.hasNext();
    }

    @Override public T next() {
        return current.next();
    }

    @Override public void remove() {
        throw new UnsupportedOperationException("cannot remove from CascadeIterator");
    }
}