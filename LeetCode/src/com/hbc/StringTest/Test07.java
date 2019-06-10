package com.hbc.StringTest;

/**
 * @Author: Beer
 * @Date: 2019/6/10 20:25
 * @Description: 子串判断
 *
 *      判断一字符串数组的元素是否是字符串的子串
 */
public class Test07 {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] bool = new boolean[n];
        for (int i = 0; i < n; i++) {
            bool[i] = check(p[i],s);
        }
        return bool;
    }
    public static boolean check(String childS, String s) {
        char[] cs = childS.toCharArray();
        char[] ss = s.toCharArray();
        if (cs.length > ss.length) return false;
        int i = 0;
        int j = 0;
        while (i < ss.length - cs.length + 1) {
            int temp = i;
            while (j < cs.length && cs[j] == ss[temp]) {
                temp++;
                j++;
            }
            if (j == cs.length) {
                return true;
            }else {
                i++;
                j = 0;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        String[] str = new String[] {"a","b","c","d"};
        String ss = "abc";
        boolean[] bool = chkSubStr(str,4,ss);
        for (boolean b : bool) {
            System.out.print(b+" ");//true true true false
        }
    }
}
