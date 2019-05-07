package com.hbc.ArrayTest;

import java.util.*;

/**
 * @Author: Beer
 * @Date: 2019/5/7 0:34
 * @Description: 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Test05 {
    public static boolean containsDuplicate(int[] nums) {
        /*
        //暴力循环法--时间复杂度太大超出时间限制
        if (nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
         */
        //---------------------------------
       /*
       //ArrayList时间复杂度太大超出时间限制
        List<Integer> list = new ArrayList<>();//有序指的是加入顺序有序还是大小有序？？？插入顺序
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                return true;
            }else {
                list.add(nums[i]);
            }
        }
        return false;
        *//**
         * 结果：100*10000跑了半天没出来，换成10000*10
         * false
         * Time: 5694ms
         */
        //------------------------------------
       /*
       //HashMap可以
         HashMap<Integer,Integer> mymap = new HashMap<>();
         for(int i = 0;i < nums.length;i++){
             if(mymap.containsKey(nums[i])){
                 return true;
             }else{
                 mymap.put(nums[i],i);
             }
         }
         return false;
        */
        /**
         * 结果：
         * false
         * Time: 1327ms
         */
        //-------------------------------------
        //Set方法可以
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
        /**
         * 结果：
         * false
         * Time: 538ms
         */
    }

    public static void main(String[] args) {
        //创造长度为100万、不重复、大小随机的数组进行检测：
        int[] nums = new int[10000 * 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i - 1;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            Random random = new Random();
            int a = random.nextInt(nums.length);
            int b = random.nextInt(nums.length);
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
        //System.out.println(Arrays.toString(nums));
        long start = System.currentTimeMillis();
        System.out.println(containsDuplicate(nums));
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }
}
