package com.hbc.ArrayTest;

import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/5/10 1:08
 * @Description:
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Test06 {

    //方法一：暴力循环法(时间复杂度O(n^2)，空间复杂度O(1))
    public static int removeElement1(int[] nums, int val) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                count++;
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                n--;
            }
        }
        return nums.length - count;
    }

    //方法2：双指针法(时间复杂度O(n)，空间复杂度O(1))即：重新赋予nums[]新的值
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //找出无需删除的元素赋予nums[]
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    //方法3：元素很少时方法2的优化（时间复杂度O(n)，空间复杂度O(1)），
    // 即：将要删除的元素与最后一个元素交换，在释放最后一元素
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = { 0,1,2,2,3,0,4,2};
        System.out.println(Arrays.toString(nums));
        removeElement(nums,2);
        System.out.println(Arrays.toString(nums));

    }
}
