package com.platform.data_structure.queue;

public class LinkQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkQueue(){
        this.head = new Node<T>(null, null);
        this.tail = new Node<T>(null, null);
        this.size = 0;
    }

    public T take() {
        if(isEmpty())
            return null;
        Node<T> node = head.next;
        head.next = head.next.next;
        size--;
        if(isEmpty()) {
            tail.next = null;
            head.next = null;
        }
        return node.data;
    }

    public T peek() {
        if(isEmpty())
            return null;
        return head.next.data;
    }

    public boolean put(T x) {
        Node<T> node = new Node<T>(x, null);
        if(isEmpty())
            head.next = tail.next = node;
        else{
            tail.next.next = node;
            tail.next = node;
        }
        size++;
        return true;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }
}
