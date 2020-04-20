package com.platform.data_structure.queue;

public class CircleQueue<T> extends LinkQueue<T> {

    private Node<T> cur = new Node<T>(null,null);
    private int step;

    public CircleQueue(int step){
        super();
        this.step = step;
    }

    public boolean connect(){
        if(size == 0)
            return false;

        tail.next.next = head.next;
        return true;
    }

    public int size(){
        return size;
    }

    public void setStep(int step){
        this.step = step;
    }

    public void start(){
        cur.next = head.next;
    }

    public T moveAndTake(){
        for (int i = 0; i < step-1; i++) {
            cur = cur.next;
        }
        T data = cur.next.data;
        cur.next = cur.next.next;
        size--;
        return data;
    }
}
