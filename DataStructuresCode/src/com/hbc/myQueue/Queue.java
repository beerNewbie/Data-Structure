package com.hbc.myQueue;

/**
 * @Author: Beer
 * @Date: 2019/5/22 20:40
 * @Description:
 */
public interface Queue<E> {
    void enQueue(E e);
    E deQueue();
    E peek();
    int getSize();
    boolean isEmpty();
}
