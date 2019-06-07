package com.hbc.myHeap;

import java.util.Random;

/**
 * @Author: Beer
 * @Date: 2019/6/7 15:59
 * @Description:
 */
public class TestHeap {
    public static void main(String[] args) {
        int n = 100;
        Random random = new Random();
        Heap<Integer> heap = new Heap<>();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(1000));
        }
        int[] nums = new int[n];
        for (int i = heap.getSize() - 1; i >= 0; i--) {
            nums[i] = heap.extractMax();
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
