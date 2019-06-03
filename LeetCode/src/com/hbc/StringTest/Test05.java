package com.hbc.StringTest;

import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/6/3 22:12
 * @Description: 大数相加
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String str = addLongInteger(s1, s2);
        System.out.println(str);
    }
    public static String addLongInteger(String addend, String augend) {
        //构造相加结果
        StringBuffer result = new StringBuffer();
        //反转字符串，便于相加
        String s1 = new StringBuffer(addend).reverse().toString();
        String s2 = new StringBuffer(augend).reverse().toString();
        //得到长度
        int len1 = s1.length();
        int len2 = s2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        //溢出判断，与相加措施
        int ov = 0;
        boolean isFlow = false;
        //使长度一致，便于相加
        if (len1 > len2) {
            for (int i = 0; i < (len1 - len2); i++) {
                s2 = s2 + "0";
            }
        }else {
            for (int i = 0; i < (len2 - len1); i++) {
                s1 = s1 + "0";
            }
        }
        //将每一位相加得到相加后的字符串
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        for (int i = 0; i < maxLen; i++) {
            int a = ch1[i] - '0';
            int b = ch2[i] - '0';
            if (a + b + ov >= 10) {
                if (i == maxLen -1) {
                    isFlow = true;
                }
                result.append(a+b-10+ov);
                ov = 1;
            }else {
                result.append(a+b+ov);
                ov = 0;
            }
        }
        if (isFlow) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
