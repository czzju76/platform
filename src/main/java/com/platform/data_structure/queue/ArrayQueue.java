package com.platform.data_structure.queue;

public class ArrayQueue<T> implements Queue<T> {
    //private Object[] items;
    private T[] items;
    private int head;
    private int tail;
    private int count;

    public ArrayQueue(int size) throws RuntimeException {
        if(size < 1)
            throw new RuntimeException("Queue's size must > 0 !");
        items = (T[]) new Object[size];   // 初始化T[]数组的方法，java不支持直接T[]
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public boolean put(T x){
        if(isFull())
            return false;
        items[tail++] = x;
        if(tail == items.length)
            tail = 0;
        count++;
        return true;
    }

    public T take(){
        if(isEmpty())
            return null;
        //T x = (T)items[head++];
        T x = items[head++];
        if(head == items.length)
            head = 0;
        count--;
        return x;
    }

    public T peek(){
        if(isEmpty())
            return null;
        //T x = (T)items[head];
        T x = items[head];
        return x;
    }


}
