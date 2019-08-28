package com.hbc.TreeTest;


/**
 * @Author: Beer
 * @Date: 2019/8/28 19:55
 * @Description: 二叉树的深度
 */

public class Test02 {

    public static int height(TreeNode root) {
        if (root == null) return 0;
        
        int leftHigh = height(root.left);
        int rightHigh = height(root.right);

        int height = Math.max(leftHigh,rightHigh) + 1;
        return height;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(height(n1));//3
    }
}
