package com.hbc.StringTest;

/**
 * @Author: Beer
 * @Date: 2019/4/18 1:03
 * @Description: 反转字符串中的单词
 *
 *     说明：给定一个字符串，你需要反转字符串中每个单词的字
 * 符顺序，同时仍保留空格和单词的初始顺序。
 */

public class Test02 {
    public static void main(String[] args) {
        String s = "olleH dlorw !!!";
        //System.out.println(s);//可以直接打印字符串
        System.out.println(reverseWords(s));//Hello wrold !!!
    }
    public static String reverseWords(String s) {
        /*
        if (s == null || s.length() == 0) return s;
        //首先按“ ”分隔出单词
        String[] strArr = s.split(" ");
        String[] newStr = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            newStr[i] = myReverse(strArr[i]);//进行反转
        }
        //进行拼接
        StringBuilder builder = new StringBuilder(newStr[0]);
        for (int i = 1; i < strArr.length; i++) {
            builder.append(" " + newStr[i]);
        }
        return builder.toString();
        */
        //优化：
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String o : str) {
            StringBuffer temp = new StringBuffer(o).reverse();
            sb.append(temp).append(" ");
        }
        return sb.toString().substring(0,sb.toString().length() - 1);
    }
    public String myReverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
}
