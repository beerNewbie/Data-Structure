package com.hbc.NumberTest;

import java.util.*;

/**
 * @Author: Beer
 * @Date: 2019/7/24 1:11
 * @Description: 有数列1, 2, 3, 4...n，整数m,在数列中随意取几个数使其和等于m，排出其字典序列
 *
 */
public class Test10 {
    //方法一：暴力列举法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n * (n + 1) / 2 < m) {
                throw new IllegalArgumentException("不存在！");

            }
            //用来记录被选到的数
            String res = "";
            //用来记录加数的综合
            int sum = 0;
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = i + 1;
            }
            printNum(num,m,res,sum,0);
        }
    }

    public static void printNum(int[] num, int m, String res, int sum, int i) {
        if (i == num.length) {
            if (sum == m) {
                //trim()方法是去掉字符串末尾的空格
                System.out.println(res.trim());
            }
            return;
        }
        //符合要求
        printNum(num,m,res+num[i]+" ",sum+num[i],i+1);
        //不符合要求
        printNum(num,m,res,sum,i+1);
    }
}
