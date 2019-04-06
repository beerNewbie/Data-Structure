package com.hbc.LinkedListTest;

/**
 * @Author: Beer
 * @Date: 2019/4/7 1:55
 * @Description: 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Test16 {
    public static  ListNode swapPairs(ListNode head) {
        /**
         //方法一：
         if(head == null || head.next == null) {
         return head;
         }
         ListNode dummyHead = new ListNode(0);
         dummyHead.next = head;
         ListNode pre = dummyHead;
         ListNode f = pre.next;
         ListNode s = f.next;
         while (pre.next != null && pre.next.next != null) {
         f.next = s.next;
         s.next = pre.next;
         pre.next = s;
         if(f.next == null) {//交换过后判断f.next是否为空
         return dummyHead.next;
         }
         pre = f;
         s = f.next.next;
         f = f.next;
         }
         return dummyHead.next;
         */
        /**
         //方法一优化：
         ListNode dummyHead = new ListNode(0);
         dummyHead.next = head;
         ListNode pre = dummyHead;
         while (pre.next != null && pre.next.next != null) {
         ListNode n1 = pre.next;
         ListNode n2 = n1.next;
         ListNode next = n2.next;

         n2.next = n1;
         n1.next = next;
         pre.next = n2;

         pre = n1;
         }
         return dummyHead.next;
         */
        //方法二：递归法：分为三个部分，head，head.next，已处理完的链表
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
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
        System.out.println("原链表：");
        printNode(n1);
        System.out.println("\n交换后后：");
        printNode(swapPairs(n1));
    }
}
/**
 * 结果：
 * 原链表：
 * 1->2->3->4
 * 交换后后：
 * 2->1->4->3
 */

