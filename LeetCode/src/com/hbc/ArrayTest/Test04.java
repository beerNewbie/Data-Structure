package com.hbc.ArrayTest;

/**
 * @Author: Beer
 * @Date: 2019/4/6 1:42
 * @Description: 删除排序数组中的重复项
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
 * 返回移除后数组的新长度。
 *      要求：不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Test04 {
    public static int removeDuplicates(int[] nums) {
        /**
         //问题？？如何把重复元素去除？将j在外部定义这样就不会出现重复元素被比较
         int n = nums.length;
         if(n == 1) return 1;
         int j = 1;
         for(int i = 0; i < n ; i++) {//i == n-1时，j肯定大于等于n，因此nums[i+1]不会执行
         for (; j < n; j++) {
         if (nums[j] != nums[i]) {
         nums[i+1] = nums[j];
         break;
         }
         if (j == n - 1){//遍历完毕
         return i + 1;
         }
         }
         }
         return 0;
         */

        //优化版
        if (nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4,4,5};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
/**
 * 结果：
 * 0 1 2 3 4 5
 */
