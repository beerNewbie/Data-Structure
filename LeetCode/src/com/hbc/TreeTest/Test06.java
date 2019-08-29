package com.hbc.TreeTest;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Beer
 * @Date: 2019/8/28 22:28
 * @Description: 二叉树的层序遍历
 */

public class Test06 {
    public static void levalOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();

            if (front == null) {
                continue;
            }

            System.out.print(front.val + " ");

            ((LinkedList<TreeNode>) queue).add(front.left);
            ((LinkedList<TreeNode>) queue).add(front.right);
        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        levalOrderTraversal(n1);
    }

    //结果：1 2 3 4 5 6 7
}
