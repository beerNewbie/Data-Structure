package com.hbc.myHeap;


import java.util.Arrays;
import java.util.Comparator;

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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
        //元素上浮
        siftUp(size - 1);
    }

    private int compare(E o1, E o2) {
        if (comparator == null) {
            //此时E必须为Comparable的子类
            return ((Comparable<E>)o1).compareTo(o2);
        }
        return comparator.compare(o1, o2);
    }

    /**
     * 元素上浮
     * @param index
     */
    private void siftUp(int index) {
        //当节点下标不为根节点并且子节点值大于父节点值时循环
        while (index > 0 && compare(elementData[index],
                elementData[parentIndex(index)]) > 0) {
            swap(index,parentIndex(index));
            index = parentIndex(index);
        }
    }

    /**
     * 进行值的交换
     * @param indexA
     * @param indexB
     */
    private void swap(int indexA, int indexB) {
        E temp = elementData[indexA];
        elementData[indexA] = elementData[indexB];
        elementData[indexB] = temp;
    }

    /**A
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

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int parentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("没有父节点");
        }
        return (index - 1) / 2;
    }

    /**
     * 找出最大值
     * @return
     */
    public E findMax() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("为空");
        }
        return elementData[0];
    }

    /**
     * 取出最大元素
     * @return
     */
    public E extractMax() {
        E result = findMax();
        //交换堆顶元素与堆尾元素的值
        swap(0,size-1);
        elementData[--size] = null;
        //进行元素下沉，保证父节点值大于左右孩子的值
        siftDown(0);
        return result;
    }
    private void siftDown(int index) {
        while (leftChildIndex(index) < size) {
            int j = leftChildIndex(index);
            //此时有右孩子
            if (j + 1 < size) {
                if (compare(elementData[j], elementData[j+1]) < 0) {
                    j++;
                }
            }
            if (compare(elementData[index], elementData[j]) > 0) {
                break;
            }
            swap(index, j);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : elementData) {
            if (e != null) {
                sb.append(e + " ");
            }
        }
        return sb.toString();
    }
}

