package com.platform.demo.data_structure.queue;

import com.platform.data_structure.queue.ArrayQueue;
import com.platform.data_structure.queue.LinkQueue;

public class QueueDemo {
    public static void main(String[] args) {
        //runArrayQueue();
        runLinkedQueue();
    }

    private static void runArrayQueue(){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(10);
        System.out.println("queue's size : " + (arrayQueue.isEmpty()?"Empty": "No Empty"));
        System.out.println("enqueue 10 data.");
        for (int i = 0; i < 10; i++) {
            arrayQueue.put(i*2);
        }
        boolean success = arrayQueue.put(10);
        System.out.println("enqueue result : " + (success?"Success": "No Success"));
        System.out.println("queue's size : " + (arrayQueue.isFull()?"Full": "No Empty"));
        System.out.println("dequeue 10 data.");
        for (int i = 0; i < 10; i++) {
            int data = arrayQueue.take();
            System.out.printf("%d\t", data);
        }
        System.out.println();
        System.out.println("queue's size : " + (arrayQueue.isEmpty()?"Empty": "No Empty"));
        System.out.println("queue's size : " + (arrayQueue.isFull()?"Full": "No Full"));
        Integer d = arrayQueue.take();
        System.out.println("dequeue result : " + ((d!=null)?"Success": "No Success"));

    }

    private static void runLinkedQueue(){
        LinkQueue<Integer> linkQueue = new LinkQueue<Integer>();
        System.out.println("queue's size : " + (linkQueue.isEmpty()?"Empty": "No Empty"));
        System.out.println("enqueue 10 data.");
        for (int i = 0; i < 10; i++) {
            linkQueue.put(i*2);
        }
        boolean success = linkQueue.put(10);
        System.out.println("enqueue result : " + (success?"Success": "No Success"));
        System.out.println("queue's size : " + (linkQueue.isFull()?"Full": "No Empty"));
        System.out.println("dequeue 10 data.");
        for (int i = 0; i < 10; i++) {
            int data = linkQueue.take();
            System.out.printf("%d\t", data);
        }
        System.out.println();
        System.out.println("queue's size : " + (linkQueue.isEmpty()?"Empty": "No Empty"));
        System.out.println("queue's size : " + (linkQueue.isFull()?"Full": "No Full"));
        Integer d = linkQueue.take();
        System.out.println("dequeue result : " + ((d!=null)?"Success": "No Success"));
        System.out.println("take again");
        d = linkQueue.take();
        System.out.println("dequeue result : " + ((d!=null)?"Success": "No Success"));
    }
}
