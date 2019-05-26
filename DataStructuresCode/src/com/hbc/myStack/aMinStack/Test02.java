package com.hbc.myStack.aMinStack;

import java.util.Stack;

/**
 * @Author: Beer
 * @Date: 2019/5/26 17:37
 * @Description: 单栈解法
 */
class MinStack1 {
    private Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        }else {
            int temp = stack.peek();
            stack.push(x);
            if (x < temp) {
                stack.push(x);
            }else {
                stack.push(temp);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int temp = stack.pop();
        int result = stack.peek();
        stack.push(temp);
        return result;
    }

    public int getMin() {
        return stack.peek();
    }
}

public class Test02 {
    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
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
}
