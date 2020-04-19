package com.platform.data_structure.list;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {
    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public T get(int idx) {
        return null;
    }

    public boolean add(int idx, T x) {
        return false;
    }

    public boolean remove(int idx) {
        return false;
    }

    public boolean set(int idx, T x) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public static class ListIterator<T> implements Iterator<T>{

        public boolean hasNext() {
            return false;
        }

        public T next() {
            return null;
        }

        public void remove() {

        }
    }
}
