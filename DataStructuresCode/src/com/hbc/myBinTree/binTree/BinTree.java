package com.hbc.myBinTree.binTree;

/**
 * @Author: Beer
 * @Date: 2019/5/27 21:05
 * @Description: 二叉树接口的定义
 */
public interface BinTree<E> {
    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    int getSize();
    boolean contains(E e );

    /**
     * 前序遍历
     */
    void preOrder();

    /**
     * 中序遍历
     */
    void inOrder();

    /**
     * 后序遍历
     */
    void postOrder();

    /**
     * 层序遍历
     */
    void levelOrder();
    /**
     * 取得最小值
     * @return
     */
    E getMin();
    E getMax();
    E removeMin();
    E removeMax();
}
