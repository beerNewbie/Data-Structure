package com.hbc.StackTest;

import java.util.Stack;

/**
 * @Author: Beer
 * @Date: 2019/8/4 20:43
 * @Description: 括号匹配问题
 */
public class Test01 {
    public static void main(String[] args) {
        String[] str = new String[] {"{}[]()","{[()]}","{{}])","{())}"};
        for (int i = 0; i < str.length; i++) {
            System.out.println(isValid(str[i]));
        }
    }

    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '{' || ch[i] == '[' || ch[i] == '(') {
                stack.push(ch[i]);
            }else {
                    if (stack.isEmpty()) {
                        return false;
                    }else if (ch[i] == '}') {
                        char temp = stack.peek();
                        if (temp == '{') {
                            stack.pop();
                            continue;
                        } else
                            return false;
                    }else if (ch[i] == ']') {
                        char temp = stack.peek();
                        if (temp == '[') {
                            stack.pop();
                            continue;
                        } else
                            return false;
                    }else if (ch[i] == ')') {
                        char temp = stack.peek();
                        if (temp == '(') {
                            stack.pop();
                            continue;
                        } else
                            return false;
                    }
                }
            }
        return true;
    }

}
