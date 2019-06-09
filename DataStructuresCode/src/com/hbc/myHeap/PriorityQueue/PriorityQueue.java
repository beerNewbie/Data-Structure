package com.hbc.myHeap.PriorityQueue;

import com.hbc.myHeap.Heap;

/**
 * @Author: Beer
 * @Date: 2019/6/9 20:48
 * @Description:
 */
public class PriorityQueue<E> implements Queue<E> {
    Heap<E> heap = new Heap<>();

    @Override
    public void enQueue(E e) {
        heap.add(e);
    }

    @Override
    public E deQueue() {
        return heap.extractMax();
    }

    @Override
    public E peek() {
        return heap.findMax();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
