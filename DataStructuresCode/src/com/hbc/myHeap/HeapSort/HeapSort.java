package com.hbc.myHeap.HeapSort;

import com.hbc.myHeap.Heap;

import java.util.Random;

/**
 * @Author: Beer
 * @Date: 2019/6/9 22:10
 * @Description: 两种方式实现堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int n = 100;
        Random random = new Random();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(1000);
        }
        heapSort2(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }
    //方法一：通过创建新的数组来排序
    public static void heapSort1(Integer[] nums) {
        int n = nums.length;
        Heap<Integer> heap = new Heap<>(nums);
        for (int i = n - 1; i >= 0; i--) {
            nums[i] = heap.extractMax();
        }
    }
    //方法二：在原数组的空间内进行排序
    public  static void heapSort2(Integer[] nums) {
        //首先将数组看成完全二叉树，找到第一个非叶子节点，以此为基点进行进行siftDown
        int n = nums.length;
        for (int i = (n - 1 -1) / 2; i >= 0; i--) {
            siftDown(nums, n, i);
        }
        //转换成二叉树后，顶尾两端元素调换，并重新进行siftDown
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0,i);
            siftDown(nums,i,0);
        }
    }
    private static void siftDown(Integer[] nums, int n, int k) {
        while ((2 * k + 1) < n) {
            int j = 2 * k +1;
            if (j + 1 < n) {
                if (nums[j] < nums[j + 1]) {
                    j++;
                }
            }
            if (nums[j] < nums[k]) {
                break;
            }
            swap(nums, j, k);
            k = j;
        }
    }
    private static void swap(Integer[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

}
