package com.hbc.ArrayTest;

/**
 * @Author: Beer
 * @Date: 2019/3/23 10:24
 * @Description:寻找两个有序数组的中位数
 */
public class Test01 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         //方法一：通过数组中的方法合并数组
         if(nums1 == null && nums2 == null){
         return 0.0;
         }
         //copy array and sort array
         int[] nums = java.util.Arrays.copyOf(nums1,nums1.length+nums2.length);//question??全拷贝需要创建新数组吗 ??需要直接通过赋值即可不需要new
         System.arraycopy(nums2,0,nums,nums1.length,nums2.length);
         java.util.Arrays.sort(nums);//sort不用大写
         int n = nums.length;
         //find midNum
         if((n - 1) % 2 == 0){
         return (nums[(n-1)/2]);
         }else{
         return (nums[(n-1)/2]+nums[(n+1)/2])/2.0;
         }
         */
        //方法二：递归法
        int m = nums1.length,n = nums2.length;
        if(m > n){//交换两数组
            int[] temp1 = nums1;
            nums1 = nums2;
            nums2 = temp1;
            int temp2 = m;
            m = n;
            n = temp2;
        }
        int iMin = 0, iMax = m, halfLen = (m + n +1)/2;//"+1"to ensure halfLen in half
        while(iMin <= iMax){
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;//to ensure "leftLength == rightLength"->"i+j == m-i+n-j"
            if(i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1;//i is to small
            }
            else if(i > iMin && nums1[i-1] > nums2[j]){
                iMax = i - 1;
            }
            else{
                int maxLeft = 0;
                if(i == 0){
                    maxLeft = nums2[j-1];
                }
                else if(j == 0){
                    maxLeft = nums1[i-1];
                }
                else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m + n) % 2 == 1){
                    return maxLeft;
                }
                int minRight = 0;
                if(i == m){
                    minRight = nums2[j];
                }
                else if(j == n){
                    minRight = nums1[i];
                }
                else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3};
        int[] B = new int[] {5,6,7,8,9};
        System.out.println(findMedianSortedArrays(A,B));//结果：5.5
    }
}
