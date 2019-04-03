package com.hbc.LinkedListTest;

/**
 * @Author: Beer
 * @Date: 2019/4/4 0:22
 * @Description: 删除倒数第n个节点
 */
public class Test15 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         //方法一：两次遍历法
         ListNode dummyHead = new ListNode(-1);
         dummyHead.next = head;
         ListNode temp = head;
         int len = 0;
         while(temp != null) {
         temp = temp.next;
         len++;
         }
         ListNode prev = dummyHead;
         for(int i = 0; i < len-n; i++) {
         prev = prev.next;
         }
         prev.next = prev.next.next;//跳过要删除的节点
         return dummyHead.next;
         */
        //方法二：双指针法,使两指针都在虚拟头结点出，第一步使f移动n+1步，若f==null则返回head.next否则将s与f同时移一步，直到f为最后一节点，此时s为要删除节点的前一个节点。
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode s = dummyHead;
        ListNode f = dummyHead;
        for(int i = 0; i < n + 1; i++) {
            f = f.next;
        }
        while(f != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dummyHead.next;
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
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println("原链表：");
        printNode(n1);
        System.out.println("\n删除后：");
        printNode(removeNthFromEnd(n1,2));
    }
}
/**
 * 结果：
 * 原链表：
 * 1->2->3->4->5
 * 删除后：
 * 1->2->3->5
 */
