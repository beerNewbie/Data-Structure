package com.hbc.myBinTree.impl;

import com.hbc.myBinTree.binTree.BinTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Beer
 * @Date: 2019/5/28 1:04
 * @Description:
 */
public class BinSearchTree<E extends Comparable> implements BinTree<E> {
    private class Node {
        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
        }
    }
    private Node root;
    private int size;

    @Override
    public void add(E e) {
        /*if (root == null) {
            Node newNode = new Node(e);
            root = newNode;
            size++;
        }
        add(root,e);*/
        root = add(root,e);
    }
    public Node add(Node node, E e) {
        if (node == null) {
            Node newNode = new Node(e);
            size ++;
            return newNode;
        }
        if (e.compareTo(node.data) < 0) {
            node.left = add(node.left,e);
        }
        if (e.compareTo(node.data) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
    /*
    public void add(Node root, E e) {
        if (root.data.equals(e)) {
            return;
        }
        else if (e.compareTo(root.data) < 0 && root.left ==null) {
            Node newNode = new Node(e);
            root.left = newNode;
            size++;
        }
        else if (e.compareTo(root.data) > 0 && root.right == null) {
            Node newNode = new Node(e);
            root.right = newNode;
            size++;
        }
        //左子树递归
        if (e.compareTo(root.data) < 0) {
            add(root.left,e);
        }
        //右子树递归
        if (e.compareTo(root.data) > 0) {
            add(root.right,e);
        }
    }
    */


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(E e) {
        return contains(root,e);
    }
    private boolean contains(Node root, E e) {
        //终止条件
        if (root == null) return false;
        if (e.equals(root.data)) return true;
        else if (e.compareTo(root.data) < 0 ) {
            //左子树递归
            return contains(root.left, e);
        }
        else {
            //右子树递归
            return contains(root.right, e);
        }
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 以当前节点作为根节点进行前序遍历
     * @param root
     */
    private void preOrder(Node root) {
        if (root == null) {
            return ;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node root) {
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node root) {
        if (root == null) {
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    @Override
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return ;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    @Override
    public E getMin() {
        return null;
    }

    @Override
    public E getMax() {
        return null;
    }

    @Override
    public E removeMin() {
        return null;
    }

    @Override
    public E removeMax() {
        return null;
    }
}
