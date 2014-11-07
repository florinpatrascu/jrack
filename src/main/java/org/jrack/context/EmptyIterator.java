package org.jrack.context;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("rawtypes")
public class EmptyIterator<T> implements Iterator<T> {
    public static final EmptyIterator it = new EmptyIterator();

    public boolean hasNext() {
        return false;
    }

    public T next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("cannot remove from EmptyIterator");
    }

    public static EmptyIterator it() {
        return it;
    }
}