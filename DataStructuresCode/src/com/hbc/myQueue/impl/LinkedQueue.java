package com.hbc.myQueue.impl;

import com.hbc.myQueue.Queue;

/**
 * @Author: Beer
 * @Date: 2019/5/22 20:42
 * @Description:
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private E data;
        private Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void enQueue(E e) {
        Node newNode = new Node(e,null);
        if (head == null) {
            head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        E result = head.data;
        head.data = null;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("队列为空");
            return null;
        }
        return head.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
