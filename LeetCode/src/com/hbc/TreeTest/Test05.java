package com.hbc.TreeTest;


/**
 * @Author: Beer
 * @Date: 2019/8/28 22:14
 * @Description:  二叉树--->双向循环链表
 */

public class Test05 {
    public static TreeNode prev = null;
    public static TreeNode first = null;
    public static void process(TreeNode node) {
        node.left = prev;

        if (prev != null) {
            prev.right = node;
        }else {
            first = node;
        }

        prev = node;
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            process(root);
            inorder(root.right);
        }
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

        inorder(n1);

        System.out.println(first.val);//3

    }

}
