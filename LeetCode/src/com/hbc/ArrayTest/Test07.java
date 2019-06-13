package com.hbc.ArrayTest;

import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/6/14 0:20
 * @Description: 微信红包
 *
 *      求数组中出现次数不小于于一半的元素，若不存在返回0；
 */
public class Test07 {
    //方法一：排序计数法
    public static int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int i = 0;
        int count = 0;
        while (i < n) {
            if (gifts[i] == gifts[n/2]) {
                count++;
            }
            i++;
        }
        return count >= n / 2 ? gifts[n/2] : 0;
    }
    //方法二：先求出众数，再判断是否是众数(最优解)
    public static int getValue2(int[] gifts, int n) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                temp = gifts[i];
                count = 1;
            }else {
                if (gifts[i] == temp) {
                    count++;
                }else {
                    count--;
                }
            }
        }
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (gifts[i] == temp) {
                size++;
            }
        }
        return size >= n / 2  ? temp : 0;

    }

    public static void main(String[] args) {
        System.out.println(getValue2(new int[]{1,2,3,2,2}, 5));//2
    }
}
