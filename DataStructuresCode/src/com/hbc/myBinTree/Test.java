package com.hbc.myBinTree;

import com.hbc.myBinTree.impl.BinSearchTree;

/**
 * @Author: Beer
 * @Date: 2019/5/28 1:20
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        BinSearchTree<Integer> binSearchTree = new BinSearchTree<>();
        int[] nums = new int[]{5,3,1,2,7,6,9};
        for (int i = 0; i < nums.length; i++) {
            binSearchTree.add(nums[i]);
        }
        System.out.println(binSearchTree.contains(5));
        System.out.println(binSearchTree.contains(10));
        binSearchTree.preOrder();//5 3 1 2 7 6 9
        System.out.println();
        binSearchTree.inOrder();//1 2 3 5 6 7 9
        System.out.println();
        binSearchTree.postOrder();//2 1 3 6 9 7 5
        System.out.println();
        binSearchTree.levelOrder();//5 3 7 1 6 9 2
        System.out.println();
       // System.out.println(binSearchTree.toString());//树化
        System.out.println(binSearchTree.getMin());//1
        System.out.println(binSearchTree.removeMin());//1
        binSearchTree.inOrder();//2 3 5 6 7 9
    }
}
