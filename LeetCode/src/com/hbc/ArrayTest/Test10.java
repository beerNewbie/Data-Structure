package com.hbc.ArrayTest;


/**
 * @Author: Beer
 * @Date: 2019/8/23 11:51
 * @Description: 二分法二维数组查找指定元素
 */

public class Test10 {

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Find(17,array));
    }

    public static boolean Find(int target, int [][] array) {
        //方法一：使用二维数组
        int row = array.length;
        for (int i = 0; i < row; i++) {
            if (findK(array[i], target) == true)
                return true;
        }
        return false;
    }

    public static boolean findK(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            }
            else if(arr[mid] > target) {
                r = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
