package com.hbc.myList;

import com.hbc.myArrays.Sequence;

import javax.xml.soap.Node;

/**
 * @Author: Beer
 * @Date: 2019/3/3 14:06
 * @Description:
 */
public class SequenceLinkImpl implements Sequence {
    private Node dummyHead;
    private int size;

    public SequenceLinkImpl() {
        this.dummyHead = new Node(null,null);
    }

    private class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
        }
    }


    @Override
    public void add(Object data) {
        addLast(data);
    }

    @Override
    public Object remove(int index) {
        rangCheck(index);
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //取得当前节点
        Node cur = node(index);
        prev.next = cur.next;
        //清空当前节点
        cur.next = cur = null;
        size--;
        return dummyHead.next;
    }

    @Override
    public Object set(int index, Object newData) {
       rangCheck(index);
       Node node = node(index);
       Object oldData = node.data;
       node.data = newData;
       return oldData;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        Node node = node(index);
        return node.data;
    }

    @Override
    public boolean isContains(Object data) {
        Object[] datas = toArray();
        if (data == null) {
            for (int i = 0; i < datas.length; i++) {
                if (datas[i] == null) {
                    return true;
                }
            }
        }else {
            for (int i = 0; i < datas.length; i++) {
                if (data.equals(datas[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] datas = new Object[size];
        int i = 0;
        for (Node temp = dummyHead.next; temp != null; temp = temp.next) {
            datas[i++] = temp.data;
        }
        return datas;
    }

    @Override
    public void clear() {
        for (Node node = dummyHead.next;node != null;) {
            node.data = null;
            Node temp = node.next;
            node.next = null;
            node = temp;
            size--;

        }
    }

    //在任意位置插入元素
    public void add(int index,Object data) {
        rangCheck(index);
        Node prev = dummyHead;
        for (int i = 0;i < size;i++) {
            prev = prev.next;
        }
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        //可优化为：prev.next = new Node(data,prev.next);
        size++;
    }
    //头插
    private void addFirst(Object data) {
        add(0,data);
    }
    //尾插
    private void addLast(Object data) {
        add(size,data);
    }
    private void rangCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("illegal index");
        }
    }
    //找到index的当前节点
    private Node node(int index) {
        Node cur = dummyHead.next;
        for (int i=0; i<index; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
