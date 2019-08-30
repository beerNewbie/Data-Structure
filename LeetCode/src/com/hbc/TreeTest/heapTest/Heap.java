package com.hbc.TreeTest.heapTest;


import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/8/29 21:44
 * @Description:
 */

public class Heap {

    /**
     *      堆化思路：首先看index位置是否是叶子，是直接return，否则找到左右孩
     * 子中值最大的节点，然后交换两位置的值，随后在递归判断最大孩子值处是
     * 否满足堆的性质
     * @param array
     * @param size
     * @param index
     */
    public static void  heapify(int[] array, int size, int index) {
        //先判断index处是不是叶子
        //没有孩子就是叶子
        //直接判断index处是否有左孩子
        //左孩子下标：left = index * 2 + 1
        int left  = 2 * index + 1;
        if (left >= size) {
            return;
        }

        //找到最大孩子的小标：
        //左孩子情况：1.只有左孩子；2.有左右孩子，左孩子大
        //右孩子情况：右孩子大
        int max = left;
        int right = 2 * index + 2;
        if (right < size) {
            if (array[left] < array[right]) {
                max = right;
            }
        }

        //判断该位置是否满足堆的性质
        if (array[index] >= array[max]) {
            return;
        }

        swap(array,index ,max);

        heapify(array,size,max);
    }

    public static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    /**
     *      建堆
     * @param array
     * @param size
     */
    public static void createHeap(int[] array,int size) {
        for (int i = (size - 2) / 2; i >=0; i--) {
            heapify(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(array));
        createHeap(array,9);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 结果：
     * [1, 2, 3, 4, 5, 6, 7, 8, 9]
     * [9, 8, 7, 4, 5, 6, 3, 2, 1]
     */
}
