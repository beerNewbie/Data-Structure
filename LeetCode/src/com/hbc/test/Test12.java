package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/16 19:12
 * @Description:深拷贝带随机指针的链表
 */

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}
    public Node (int val) {
        this.val = val;
    }

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
public class Test12 {
    private static Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        //复制链表，使原节点后都有一个拷贝的节点
        while (cur != null) {
            Node temp = new Node(cur.val,null,null);//值和next都相同
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        //将random赋给拷贝后的节点
        cur = head;
        while (cur != null && cur.next !=null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //断开链表
        cur = head;
        Node copyNode = cur.next;
        while (cur != null) {
            Node next = cur.next;
            if (next != null) {
                cur.next = next.next;
            }
            cur = next;
        }
        return copyNode;

    }
    private static void printNode(Node node) {
        for (Node temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
        }

    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;

        printNode(n1);
        System.out.println();
        printNode(copyRandomList(n1));
    }

}
