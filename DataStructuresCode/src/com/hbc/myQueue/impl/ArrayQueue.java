package com.hbc.myQueue.impl;

import com.hbc.myQueue.Queue;

/**
 * @Author: Beer
 * @Date: 2019/5/22 20:52
 * @Description:
 */
public class ArrayQueue<E> implements Queue<E> {
    //不能直接new一个泛型数组
    //因为由于JVM泛型擦除机制，运行时JVM不知道泛型信息，再取出数据时会出现类型转换异常；
    //而在编译期不出现警告错误（泛型 参数化类型；编译期检测）
    private Object[] elementData;
    //队列头
    private int head;
    //队列尾（为最后存放数据的后一位
    private int tail;
   // private int capacity;

    public ArrayQueue(int maxSize) {
        elementData = new Object[maxSize];
    }

    @Override
    public void enQueue(E e) {
        if (tail == elementData.length) {
            if (head == 0) {
                System.err.println("当前队列已满");
                return;
            }else {
                //数据搬移
                for (int i = head; i < tail; i++) {
                    elementData[i-head] = elementData[i];
                }
                tail = tail - head;
                head = 0;
            }
        }
        elementData[tail++] = e;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            System.err.println("当前队列为空!");
            return null;
        }
        return (E) elementData[head++];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("当前队列为空");
            return null;
        }
        return (E) elementData[head];
    }

    @Override
    public int getSize() {
        return tail-head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
