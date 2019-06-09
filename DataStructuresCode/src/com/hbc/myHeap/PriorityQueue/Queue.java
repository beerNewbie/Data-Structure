package com.hbc.myHeap.PriorityQueue;

/**
 * @Author: Beer
 * @Date: 2019/6/9 20:45
 * @Description:
 */
public interface Queue<E> {
    void enQueue(E e);
    E deQueue();
    E peek();
    boolean isEmpty();
}
