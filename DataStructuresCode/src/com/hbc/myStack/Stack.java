package com.hbc.myStack;

/**
 * @Author: Beer
 * @Date: 2019/5/25 22:45
 * @Description: 栈的接口声明
 */
public interface Stack {
    void push(Object o);
    Object pop();
    Object peek();
    int getSize();
    boolean isEmpty();
}
