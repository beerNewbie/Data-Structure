package com.hbc.NumberTest;

/**
 * @Author: Beer
 * @Date: 2019/3/29 23:47
 * @Description:求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 假设数组是非空的，并且给定的数组总是存在众数。
 */
public class Test03 {
    public static int majorityElement(int[] nums) {
        //方法一：
        int n = nums.length;
        int i = 1;
        int temp = nums[0];
        int count = 1;
        while(i < n){
            if(temp == nums[i]) {
                count++;
            }else {
                count--;
                if(count == 0) {
                    temp = nums[i+1];
                }
            }
            i++;
        }
        return temp;

        //方法二：
        // Arrays.sort(nums);
        // return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2,3,2,2,1,2}));
    }
}
