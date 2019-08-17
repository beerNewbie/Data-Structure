package com.hbc.ArrayTest;

import java.util.*;

/**
 * @Author: Beer
 * @Date: 2019/8/17 21:10
 * @Description:
 *
 *
 * Shopee物流会有很多个中转站。在选址的过程中，会选择离用户最近的地方建一个物流中转站。
 *
 * 假设给你一个二维平面网格，每个格子是房子则为1，或者是空地则为0。找到一个空地修建一
 * 个物流中转站，使得这个物流中转站到所有的房子的距离之和最小。 能修建，则返回最小的距
 * 离和。如果无法修建，则返回 -1。
 *
 *
 * 若范围限制在100*100以内的网格，如何计算出最小的距离和？
 *
 * 当平面网格非常大的情况下，如何避免不必要的计算
 *
 * 测试用例：
 * 4
 * 0 1 1 0
 * 1 1 0 1
 * 0 0 1 0
 * 0 0 0 0
 */

public class Test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int[][] res = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    res[i][j] = 0;
                }
            }
            /**
             * 思路：
             * 首先建立一个返回数组，从前往后遍历，遇到0就遍历后面所有1的个数，遇到1，就往后面0的位置加上两者间的距离。
             *
             */
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {


                    if (arr[i][j] == 0) {
                        int p = j;
                        for (int k = i; k < n; k++) {
                            for (; p < n; p++) {
                                if (arr[k][p] == 1) {
                                    //遇到1的时候在该位置加上所有到1未知的距离
                                    res[i][j] += (Math.abs(k - i) + Math.abs(p - j));
                                }
                            }
                            p = 0;
                        }

                    }else {
                        //若位置是1，直接是赋值整形最大数
                        res[i][j] = Integer.MAX_VALUE;
                        int p = j;
                        for (int k = i; k < n; k++) {
                            for (; p < n; p++) {
                                if (arr[k][p] == 0) {
                                    //在后面是0的位置，加上距离
                                    res[k][p] += (Math.abs(k - i) + Math.abs(p - j));
                                }
                            }
                            p = 0;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }

            int minWay = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (minWay > res[i][j]) {
                        minWay = res[i][j];
                    }
                }
            }
            minWay = minWay == Integer.MAX_VALUE ? -1 : minWay;
            System.out.println(minWay);
        }
    }
    /**
     * 14 2147483647 2147483647 14
     * 2147483647 2147483647 8 2147483647
     * 16 12 2147483647 16
     * 22 18 18 22
     * 8
     */
}
