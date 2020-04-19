package com.platform.data_structure.list;

public interface List<T> extends Iterable<T> {

    int size();
    boolean isEmpty();
    boolean isFull();
    T get(int idx);
    boolean add(int idx, T x);
    boolean remove(int idx);
    boolean set(int idx, T x);

}
