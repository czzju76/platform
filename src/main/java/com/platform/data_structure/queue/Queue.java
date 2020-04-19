package com.platform.data_structure.queue;

public interface Queue<T> {
    /**
     * 取出队列头数据。如果队列为空，返回null。
     * @return
     */
    T take();

    /**
     * 获得队列头数据，但不取出。如果队列为空，返回null。
     * @return
     */
    T peek();

    /**
     * 将数据放入队列尾。如果队列为满，返回false。
     * @param x
     * @return
     */
    boolean put(T x);

    /**
     * 队列满时，返回true。
     * @return
     */
    boolean isFull();

    /**
     * 队列空时，返回false。
     * @return
     */
    boolean isEmpty();

}
