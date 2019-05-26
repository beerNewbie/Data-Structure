package com.hbc.myStack.aMinStack;

import java.util.Stack;

/**
 * @Author: Beer
 * @Date: 2019/5/26 17:06
 * @Description: 最小栈问题 --双栈解法
 *   设计一个支持puch、pop、top操作，时间复杂度为O(n)
 */

class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        dataStack.push(x);
    }

    public void pop() {
        //此时不能用==，因为Integer比较的是地址，用equals比较
        if (dataStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        dataStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class Test01 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(200);
        minStack.push(-260);
        minStack.push(-260);
        minStack.push(360);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
    /**
     * 结果：
     * -260
     * -260
     * 200
     */
}
