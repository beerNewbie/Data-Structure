package com.hbc.myStack.implStack;

import com.hbc.myStack.Stack;

import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/5/25 22:47
 * @Description: 基于数组的顺序栈
 */
public class ArrayStack implements Stack {
    private Object[] items;
    //栈中元素个数
    private int count;
    //栈的大小
    private int n;

    public ArrayStack(int n) {
        this.n = n;
        this.items = new Object[n];
        this.count = 0;
    }

    /**
     * 入栈操作；基于数组动态扩容
     * @param o
     */
    @Override
    public void push(Object o) {
        //数组空间不足时
        if (count == n) {
            int oldCount = n;
            int newCount = oldCount << 1;
            //当栈大小超出int最大值
            if (((newCount + 8) - Integer.MAX_VALUE) > 0) {
                System.err.println("栈大小超过最大值 ");
                return;
            }
            n = newCount;
            items = Arrays.copyOf(items,newCount);
        }
        items[count] = o;
        ++count;
    }

    /**
     * 出栈操作
     * @return
     */
    @Override
    public Object pop() {
        //栈为空直接返回null
        if (count == 0) {
            return null;
        }
        Object temp = items[count-1];
        --count;
        return temp;
    }

    @Override
    public Object peek() {
        return items[count-1];
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
