package com.hbc.myHeap;

import java.util.Random;

/**
 * @Author: Beer
 * @Date: 2019/6/7 15:59
 * @Description:
 */
public class TestHeap {
    public static void main(String[] args) {
        /*int n = 100;
        Random random = new Random();
        Heap<Integer> heap = new Heap<>();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(1000));
        }
        int[] nums = new int[n];
        for (int i = heap.getSize() - 1; i >= 0; i--) {
            nums[i] = heap.extractMax();
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                throw new IllegalArgumentException("不是堆");
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }*/
        Integer[] nums = new Integer[] {0,1,2,3,4,5,6,7,8,9};
        Heap<Integer> heap = new Heap<>(nums);
        System.out.println(heap);//9 8 6 7 4 5 2 0 3 1
    }
}
