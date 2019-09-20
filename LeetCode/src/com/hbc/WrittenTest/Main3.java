package com.hbc.WrittenTest;

import java.util.*;
/**
 * @Author: Beer
 * @Date: 2019/9/20 20:13
 * @Description: 企鹅王国电话号码
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int[] len = new int[n];
        String[] strs = new String[n];

        while (i < n) {
            len[i] = scanner.nextInt();
            scanner.nextLine();
            strs[i] = scanner.nextLine();
            i++;
        }
        for (int j = 0; j < n; j++) {
            printIsNum(len[j],strs[j]);
        }
    }
    public static void printIsNum(int len, String str) {
        char[] chs = str.toCharArray();
        if (len < 11 || (len == 11 && chs[0] != '8')) {
            System.out.println("NO");
            return;
        }
        int j = 0;
        int count = len;
        boolean flag = false;
        while (j <= len - 11) {
            if (chs[j] == '8') {
                flag = true;
            } 
            j++;
        }
        if (!flag) {
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }

    }
}