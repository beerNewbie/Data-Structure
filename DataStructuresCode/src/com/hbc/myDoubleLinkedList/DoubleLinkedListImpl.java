package com.hbc.myDoubleLinkedList;

import com.hbc.myArrays.Sequence;

import javax.xml.soap.Node;

/**
 * @Author: Beer
 * @Date: 2019/3/6 11:14
 * @Description:
 */
public class DoubleLinkedListImpl implements Sequence {
    private Node head;
    private Node tail;
    private int size;

    private class Node  {
        Node prev;
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void add(Object data) {
        //新节点尾插入链表
        Node newNode = new Node(tail,data,null);
        if (head == null) {
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public Object remove(int index) {
        rangeCheck(index);
        //要删除的节点
        Node cur = findNode(index);
        Node curPrev = cur.prev;
        Node curNext = cur.next;
        //要删除的是头结点
        if (curPrev == null) {
            head = cur.next;
        }else{//存在前驱节点
            curPrev.next = cur.next;
            cur.next = null;
        }
        //要删除的是尾节点
        if (curNext == null) {
            tail = cur.prev;
        }else {
            curNext.prev = cur.prev;
            cur.prev = null;
        }
        size--;
        return null;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Node node = findNode(index);
        Object oldData = node.data;
        node.data = newData;
        return oldData;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return findNode(index).data;
    }

    @Override
    public boolean isContains(Object data) {
        //先将链表换位数组
        Object[] datas = toArray();
        if (data == null) {
            for (int i = 0; i < datas.length; i++) {
                if (datas[i] == null){
                    return true;
                }
            }
            return false;
        }else {
            for (int i = 0; i < datas.length; i++) {
                if (datas[i] == data) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size];
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            obj[i++] = temp.data;
        }
        return  obj;
    }

    @Override
    public void clear() {
        for (Node temp = head; temp != null;) {
            Node next = temp.next;
            temp.data = null;
            temp.prev = temp.next = null;
            temp = next;
            size--;
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegale Index!");
        }
    }

    private Node findNode(int index) {
        rangeCheck(index);
        //在左边时
        if(index < (size >> 1)){
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }else{
            Node temp = tail;
            for (int i = size-1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }

    }
}
