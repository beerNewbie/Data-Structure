package com.hbc.myStack.implStack;

import com.hbc.myStack.Stack;

/**
 * @Author: Beer
 * @Date: 2019/5/25 22:45
 * @Description:
 */
public class LinkedStack implements Stack {
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }

    private Node head = null;
    private int size = 0;
    @Override
    public void push(Object o) {
        //头插法
        Node newNode = new Node(o,null);
        //判断栈是否为空
        if (head == null) {
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        ++size;
    }

    @Override
    public Object pop() {
        if (head == null) {
            return null;
        }
        Object data = head.data;
        head = head.next;
        --size;
        return data;
    }

    @Override
    public Object peek() {
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
