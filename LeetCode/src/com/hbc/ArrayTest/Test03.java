package com.hbc.ArrayTest;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Beer
 * @Date: 2019/4/5 14:43
 * @Description: 只出现一次的数字
 *      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 */
public class Test03 {
    public static int singleNumber(int[] nums) {
        //线性时间复杂度O(n)
        /**
         //方法一：两次遍历法   问题？？？后面的与前面相等了如何跳过？？用了HashSet
         int len = nums.length;
         HashSet<Integer> hash = new HashSet<Integer>();
         for(int i = 0; i < len; i++) {
         if(hash.contains(nums[i])) {
         continue;//跳过已经与前面相等的元素
         }
         int j = i + 1;
         for(; j < len; j++) {
         if(nums[i] == nums[j]) {
         //flag = nums[i];//bug：flag的值会变
         hash.add(nums[i]);
         break;
         }
         }
         if(j == len) {
         return nums[i];
         }
         }
         throw new ArrayIndexOutOfBoundsException("Not found");
        */

        /**
         //方法二：通过数组排序，根据题意可直接进行判断
         Arrays.sort(nums);
         for(int i = 0; i < nums.length; i+=2) {
         if(i == nums.length - 1) {
         return nums[i];
         }
         if(nums[i] != nums[i+1]) {
         return nums[i];
         }
         }
         throw new ArrayIndexOutOfBoundsException("Not found");
        */

        //方法三：异或法（满足交换律）：相同为0，不同为一，则两相同的数异或则一定为0，而0与其他数异或结果不变
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {1,2,2,3,1}));
    }
}
/**
 结果：3
 */