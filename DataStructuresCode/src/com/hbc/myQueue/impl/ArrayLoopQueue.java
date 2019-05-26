package com.hbc.myQueue.impl;

import com.hbc.myQueue.Queue;

/**
 * @Author: Beer
 * @Date: 2019/5/26 20:00
 * @Description:
 */
public class ArrayLoopQueue<E> implements Queue<E> {
    private Object[] elementData;
    private int head;
    private int tail;

    public ArrayLoopQueue(int maxSize) {
        elementData = new Object[maxSize+1];//+1用于区分环形队列的空满
    }
    @Override
    public void enQueue(E e) {
        if ((tail+1) % elementData.length == head) {
            System.err.println("队列已满");
            return;
        }
        elementData[tail] = e;
        tail = (tail+1)%elementData.length;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        E result = (E) elementData[head];
        head = (head + 1) % elementData.length;
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        return (E) elementData[head];
    }

    @Override
    public int getSize() {
        if (tail - head > 0) {
            return tail - head;
        }else {
            return elementData.length - (head - tail);
        }
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
