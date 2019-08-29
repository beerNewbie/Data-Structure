package com.hbc.TreeTest;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Beer
 * @Date: 2019/8/29 12:55
 * @Description: 判断一棵二叉树是否是完全二叉树
 */

public class Test07 {
    public static boolean isCompleteTree(TreeNode root) {
        //1.不断层序遍历，直到遇到一个null为止
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);

        while (true) {
            TreeNode front = queue.poll();
            if (front == null) {
                break;
            }
            ((LinkedList<TreeNode>) queue).add(front.left);
            ((LinkedList<TreeNode>) queue).add(front.right);
        }

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();

            if (front != null) {
                return false;
            }
        }

        return true;


        //2.检查队列剩余节点中是否还有非空元素
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        //TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        //n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        if (isCompleteTree(n1)) {
            System.out.println("是完全二叉树");
        }else {
            System.out.println("不是完全二叉树");//不是完全二叉树
        }
    }

}
