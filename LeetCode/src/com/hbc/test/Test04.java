package com.hbc.test;

import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/3/6 23:12
 * @Description:反转指定位置的单链表
 * 1 ≤ m ≤ n ≤ 链表长度
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Test04 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //首先找到m位置的前一点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        for(int i=1; i<m; i++) {
            temp = temp.next;
        }
        //在通过反转链表法对m->n间的链表进行反转
        ListNode f = temp.next;
        ListNode s = f.next;
        int i = 0;
        while(i<(n-m)){
            f.next = s.next;
            s.next = temp.next;
            temp.next = s;
            s = f.next;
            i++;
        }
        return dummyHead.next;
    }

    public static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val+"->");
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
        printNode(n1);
        System.out.println();
        Test04 test = new Test04();
        ListNode result = test.reverseBetween(n1,1,5);
        printNode(result);
    }
}
