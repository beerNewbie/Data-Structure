package com.hbc.TreeTest;


/**
 * @Author: Beer
 * @Date: 2019/8/28 21:10
 * @Description:  找二叉树中查找与val值相同的节点
 */

public class Test04 {

    public static TreeNode searchVal(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        if (root.val == val) {
            return root;
        }


        //先去左子树查找，若不为null则找到直接返回
        TreeNode leftTreeNode = searchVal(root.left,val);
        if (leftTreeNode != null) {
            return leftTreeNode;
        }

        //否则返回右子树的查找结果
        return searchVal(root.right,val);
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

        TreeNode res = searchVal(n1,6);
        if (res != null) {

            System.out.println("找到了");//找到了
        }else {
            System.out.println("找不到");
        }

    }


}
