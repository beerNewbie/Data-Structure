package com.hbc.LinkedListTest;


/**
 * @Author: Beer
 * @Date: 2019/8/28 18:29
 * @Description:  反转单链表
 */

public class Test18 {

    public  static ListNode reverseList(ListNode head) {
        /*
        //方法一：头插法

        //首先令一个newHead为（指向）新连链表的第一个节点，cur为需要操作的节点

        ListNode newHead = null;
        ListNode cur = head;

        while (cur != null) {
            //保存下一个引用
            ListNode next = cur.next;

            cur.next = newHead;
            newHead = cur;

            cur = next;
        }

        return newHead;
        */

        //方法二：三指针法
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            cur.next = pre;

            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;

    }

    private static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("反转前：");
        printNode(n1);
        System.out.println("\n反转后：");
        printNode(reverseList(n1));
    }
    /**
     * 结果：
     * 反转前：
     * 1->2->3->4
     * 反转后：
     * 4->3->2->1
     */

}
