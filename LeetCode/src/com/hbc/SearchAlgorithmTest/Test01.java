package com.hbc.SearchAlgorithmTest;

import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/7/28 18:59
 * @Description:  一个盒子只能放一张牌，有n个盒子，n张牌，共有多少种放法？？
 *
 *      深度优先算法
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //盒子、牌编号从1开始
        int[] box = new int[n+1];
        int[] book = new int[n+1];
        dfsFun(1,n,box,book);

    }

    public static void dfsFun(int index, int n, int[] box, int[] book) {
        if (index == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(box[i]);
            }
            System.out.println();
            return ;//向上回退
        }

        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {//第i号牌仍在手上
                box[index] = i;
                book[i] = 1;//第i号牌被占用
                //处理下一个盒子
                dfsFun(index+1,n,box,book);
                //从下一个盒子回退到当前盒子，取出当前盒子的牌
                //尝试放入其他牌
                book[i] = 0;
            }
        }
        /**
         * 结果：
         * 3
         * 123
         * 132
         * 213
         * 231
         * 312
         * 321
         */
    }
}
