package com.hbc.StringTest;


import java.util.ArrayList;

/**
 * @Author: Beer
 * @Date: 2019/8/31 23:42
 * @Description: 将字符串中" "替换为"%20"
 */

public class Test09 {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            System.err.println("str为null!!!");
        }
        String ss = str.toString();
        ss = ss.replaceAll(" ", "%20");

        return ss;
    }
    public static String replaceSpace1(StringBuffer str) {
        if (str == null) {
            System.err.println("str为null!!!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ' ') {
                sb.append("%20");
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(" An apple ");
        System.out.println(replaceSpace1(null));
    }
}
