package com.hbc.TreeTest;


/**
 * @Author: Beer
 * @Date: 2019/8/28 20:26
 * @Description: 找二叉树的最近公共祖先
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */

public class Test03 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //首先树分为三个部分，依次判断

        if (root == p || root == q) return root;

        //判断p/q是否都在同一边
        boolean pInLeft = search(root.left, p);
        boolean qInLeft = search(root.left, q);

        //都在左边
        if (pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //都在右边
        if (!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }

    public static boolean search(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }

        if (search(root.left,p)) {
            return true;
        }
        return search(root.right,p);

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
        TreeNode res1 = lowestCommonAncestor(n1,n6,n7);
        System.out.println(res1.val);//5
        TreeNode res2 = lowestCommonAncestor(n1,n2,n5);
        System.out.println(res2.val);//2
        TreeNode res3 = lowestCommonAncestor(n1,n5,n6);
        System.out.println(res3.val);//1


    }
}
