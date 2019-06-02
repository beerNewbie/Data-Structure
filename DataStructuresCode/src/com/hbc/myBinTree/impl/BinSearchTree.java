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
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minNode = getMinNode(root);
        return minNode.data;
    }
    private Node getMinNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }


    @Override
    public E getMax() {
        if (root == null) {
            throw new IllegalArgumentException("BST is Empty");
        }
        Node maxNode = getMaxNode(root);
        return maxNode.data;
    }
    private Node getMaxNode(Node node) {
        if(node.right == null) {
            return node;
        }
        return getMaxNode(node.right);
    }


    @Override
    public E removeMin() {
        E result = getMin();
        root = removeMinNode(root);
        return result;
    }
    private Node removeMinNode(Node root) {
        if (root.left == null) {
            Node temp = root.right;
            root.right = null;
            size --;
            return temp;
        }
        root.left = removeMinNode(root.left);
        return root;
    }

    @Override
    public E removeMax() {
        E result = getMax();
        root = removeMaxNode(root);
        return result;
    }
    private Node removeMaxNode(Node node) {
        if (node.right == null) {
            Node temp = node.left;
            node.left = null;
            size --;
            return temp;
        }
        node.right = removeMaxNode(node);
        return node;
    }


    @Override
    public E remove() {
        return null;
    }
    /**
     *递归删除已node为根节点的二叉树中值为e的节点
     * @param node 根节点
     * @param e 要删除的值
     * @return
     */
    private Node removeNode(Node node, E e) {
        if (node == null) {
            return null;
        }
        //要删除的节点在node的左子树：
        else if (e.compareTo(node.data) < 0) {

        }
        //要删除的节点在node的右子树：
        else if (e.compareTo(node.data) > 0) {

        }
        //刚好就是要删除node节点：
        else {

        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateTreeStruct(root,0,sb);
        return sb.toString();
    }
    /**
     * 前序遍历图形化二叉树
     * @param root 节点
     * @param deep 深度
     * @param sb
     */
    private void generateTreeStruct(Node root, int deep, StringBuilder sb) {
        if (root == null) {
            sb.append("null" + "\n");
            return ;
        }
        sb.append(generatePaint(deep) + root.data + "\n");
        generateTreeStruct(root.left,deep+1,sb);
        generateTreeStruct(root.right,deep+1,sb);
    }
    private String generatePaint(int deep) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
}
