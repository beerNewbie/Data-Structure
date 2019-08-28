package com.hbc.TreeTest;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/8/28 19:23
 * @Description: 二叉树的前序遍历
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test01 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.add(root.val);
        List<Integer> leftList = preorderTraversal(root.left);
        List<Integer> rightList = preorderTraversal(root.right);

        list.addAll(leftList);
        list.addAll(rightList);

        return list;
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
        List<Integer> lists = preorderTraversal(n1);
        for (int list : lists) {
            System.out.print(list + " ");//1 2 3 4 5 6 7
        }
    }

}
