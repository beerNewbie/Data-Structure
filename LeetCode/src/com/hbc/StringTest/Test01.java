package com.hbc.StringTest;

/**
 * @Author: Beer
 * @Date: 2019/4/18 0:52
 * @Description: 反转字符串
 */
public class Test01 {
    public static void main(String[] args) {
       char[] s = new char[]{'h','e','l','l','o'};
       reverseString(s);
       for (char o : s) {
           System.out.print(o);
       }
    }
    public static void reverseString(char[] s) {
        //问题：1.char初始化？？\u0000 2.如何对临时变量char进行赋值？？？char temp = s[i];
        //方法一；创建临时变量法
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }

        /*
        //方法二：转换为字符串(需分配额外空间)
        String str = new String(s);
        for (int i = 0; i < str.length(); i++) {
            s[i] = str.charAt(str.length()-i-1);
        }
        */
    }
}
/**
 结果：olleh
 */