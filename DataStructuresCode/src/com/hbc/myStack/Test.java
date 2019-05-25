package com.hbc.myStack;

import com.hbc.myStack.implStack.ArrayStack;
import com.hbc.myStack.implStack.LinkedStack;

/**
 * @Author: Beer
 * @Date: 2019/5/25 23:15
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Stack stack = new LinkedStack();
        //Stack stack = new ArrayStack(2);
        stack.push("a");
        stack.push("bc");
        stack.push(1);
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        /**
         * 结果：
         * 3
         * 1
         * bc
         * 2
         * false
         */
    }
}
