package com.hbc.ArrayTest;

import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/3/28 18:35
 * @Description:合并两个有序数组
 */
public class Test02 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         //方法一：调用方法部分拷贝数组并排序
         if(nums1.length >= m + n){
         System.arraycopy(nums2,0,nums1,m,n);
         Arrays.sort(nums1);
         }else {
         return ;
         }
         */
        //方法二：比较，大的放后面《好方法》
        int p = m-- + n-- - 1;
        while(m >= 0 && n >=  0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while(n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));//结果：[1,2,2,3,5,6]
    }
}
