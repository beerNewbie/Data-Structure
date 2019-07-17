package com.hbc.ArrayTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/7/17 13:26
 * @Description: 二维数组的应用
 *
 *       一个木棒集合，每根木棒知道长度，问能否用这些木棒构成一个面积大于0的简单多边形
 * （不能自交）。数据有n次操作，每次操作要么增加一根长度为x的木棒，要么去掉一根长度为x的木棒，每
 * 次操作完后问剩下的木棒能否满足上述条件。
 *
 */
public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            operateFun(arr,n);
        }
    }
    private static void operateFun(int[][] arr, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 1) {
                list.add(arr[i][1]);
            }else {
                list.remove(new Integer(arr[i][1]));
            }
            if (isSuccess(list)) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
    private static boolean isSuccess(List<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int temp = list.remove(i);
            int sum = 0;
            for (int j = 0; j < len - 1; j++) {
                sum += list.get(j);
            }
            if (sum <= temp) {
                list.add(i,temp);
                return false;
            }
            list.add(i,temp);
        }
        return true;
    }
}
