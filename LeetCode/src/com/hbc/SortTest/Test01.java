package com.hbc.SortTest;

import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/6/8 13:14
 * @Description: 字典序列
 *
 * 给定一个从小到大的已排序数列，输出其从小到大的全排列
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String str  =sc.nextLine();
        int[] nums = new int[n];
        String[] s = str.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        prim(nums,n);
    }
    //全排列:
    public static void prim(int[] nums,int n) {
        int count = 1, a = 0,b = 0;
        //循环次数
        for (int i = 1; i <= n; i++) {
            count *= i;
        }
        //每次进行循环输出
        while ((count--) != 0) {
            //输出数组
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();

            //从右往左找出第一个左边小于右边的数
            for (int i = n - 1; i > 0; i--) {
                if (nums[i-1] < nums[i]) {
                    a = i - 1;
                    break;
                }
            }
            //从右往左找出第一个大于上一个的左边数
            for (int i = n - 1; i > a; i--) {
                if (nums[i] > nums[a]) {
                    b = i;
                    break;
                }
            }

            //交换下标为a、b的元素的值
            swapFun(nums,a,b);
            //将数组中[a,n)之间元素进行重排序
            sortFun(nums,a,n);
        }
    }

    public static void swapFun(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sortFun(int[] nums, int a, int n) {
        for (int i = 1; i < n - a; i++) {
            for (int j = a + 1; j < n - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    swapFun(nums,j,j+1);
                }
            }
        }
    }
}
