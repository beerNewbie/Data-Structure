package com.hbc.StringTest;

import java.util.Stack;

/**
 * @Author: Beer
 * @Date: 2019/5/27 20:08
 * @Description: 有效括号
 */
public class Test04 {

   //方法1：直接比较法
   public static boolean isValid1(String s) {
       if (s == null || s.length() == 1) return false;
       if (s.length() == 0) return true;
       char[] ch = s.toCharArray();
       Stack<Character> stack = new Stack<>();
       int i = 0;
       if (s.length() % 2 != 0) return false;
       while (i < s.length()) {
           if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
               stack.push(ch[i]);
               i++;
           }
           else if (i == 0) return false;
           else if (ch[i] == ')') {
               if (stack.peek() != '(') {
                   return false;
               }else {
                   stack.pop();
                   i++;
               }
           }
            else if (ch[i] == ']') {
               if (stack.peek() != '[') {
                   return false;
               }else {
                   stack.pop();
                   i++;
               }
           }
           else if (ch[i] == '}') {
               if (stack.peek() != '{') {
                   return false;
               }else {
                   stack.pop();
                   i++;
               }
           }
       }
       if (!stack.isEmpty()) {
           return false;
       }
       return true;
   }

    //方法1优化
    public static boolean  isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (stack.isEmpty()) {
                stack.push(c);
            }
            else if (check(stack.peek(), c)) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    public static boolean check(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '{' && c2 == '}');
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}()[]"));//true
        System.out.println(isValid("}{}()"));//false
        System.out.println(isValid("({[}])"));//false
    }
}
