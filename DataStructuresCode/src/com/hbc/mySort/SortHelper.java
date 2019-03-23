package com.hbc.mySort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Beer
 * @Date: 2019/3/7 19:42
 * @Description:
 */
public class SortHelper {
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    //生成随机数组
    public static int[] creatRandomArray(int n,int l,int r) {
        int[] array = new int[n];
        if (l > r) {
            throw new ArrayIndexOutOfBoundsException("illegal index!!!");
        }
        for (int i = 0; i < n; i++) {
            array[i] = new Random().nextInt((r - l + 1) + l);
        }
        return array;
    }
    //生成近乎有序的随机数组
    public static int[] generateNearlySortedArray(int n,int swapTimes) {
        int[] result = new int[n];
        //先构造完全有序数组
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        //随机选取范围内两下标进行交换
        for (int i = 0; i < swapTimes; i++) {
            Random random = new Random();
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            int temp = result[a];
            result[a] = result[b];
            result[b] = temp;
        }
        return result;
    }
    //拷贝数组
    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array,array.length);
    }
}
