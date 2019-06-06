package com.hbc.myHeap;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Author: Beer
 * @Date: 2019/6/6 19:30
 * @Description:基于数组实现二叉堆
 */
public class Heap<E> {
    private Comparator<E> comparator;//如何实现比较
    private E[] elementData ;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Heap() {
        this(DEFAULT_CAPACITY,null);
    }

    public Heap(int initialCapacity) {
        this(initialCapacity,null);
    }

    public Heap(int initialCapacity,Comparator<E> comparator) {
        this.elementData = (E[]) new Object[initialCapacity];
        this.comparator = comparator;
    }



    /**
     * 添加元素
     * @param e
     */
    public void add(E e) {
        if (size == elementData.length) {
            //扩容
            grow();
        }
        elementData[size++] = e;
        siftUp(size - 1);
    }

    /**
     * 元素上浮
     * @param index
     */
    private void siftUp(int index) {

    }

    /**
     * 扩容
     */
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity < 64 ?
                oldCapacity : oldCapacity >> 1);
        if (newCapacity > Integer.MAX_VALUE -8) {
            throw new ArrayIndexOutOfBoundsException("达到最大值，无法扩容");
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }
}
