package com.hbc.myArrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/3/1 21:21
 * @Description:
 */


public class SequenceArrayImpl implements Sequence{
    private final static int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public SequenceArrayImpl() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(Object data) {
        ensureCapacity(size+1);//确保不越界
        elementData[size++] = data;
    }

    @Override
    public Object remove(int index) {
        rangCheck(index);
        Object oldData = elementData[index];
        int moveSize = size - index - 1;
        if (moveSize > 0) {
            System.arraycopy(elementData,index+1,elementData,index,moveSize);
        }
        elementData[--size] = null;
        return oldData;
    }

    @Override
    public Object set(int index, Object newData) {
        rangCheck(index);
        Object oldData = elementData[index];
        elementData[index] = newData;
        return oldData;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        return elementData[index];
    }

    @Override
    public boolean isContains(Object data) {
        if (data == null) {
            for (int i = 0;i < size;i++) {
                if (elementData[i] == null) {
                    return true;
                }
            }
        }else {
            for (int i = 0;i < size;i++) {
                if (elementData[i].equals(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }

    @Override
    public void clear() {
        for (int i = 0;i < size;i++) {
            elementData[i] = null;
        }
        this.size = 0;
    }

    private void ensureCapacity(int minCap) {
        if(minCap - elementData.length >0) {
            grow(minCap);
        }
    }

    private void grow(int minCap) {
        int oldCap = elementData.length;
        int newCap = oldCap << 1;//扩大2倍
        if (newCap - minCap < 0) {
            newCap = minCap;
        }
        if (newCap - MAX_ARRAY_SIZE > 0) {
            throw new ArrayIndexOutOfBoundsException("超过数组最大阈值");
        }
        elementData = Arrays.copyOf(elementData,newCap);
    }

    private void rangCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("下标不存在");
        }
    }
}
