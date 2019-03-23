package com.hbc.LinkedListTest;

/**
 * @Author: Beer
 * @Date: 2019/3/4 17:36
 * @Description:反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class Test01 {
    public static ListNode reversList(ListNode head) {
        //方法1
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        if (head == null || head.next == null) {
            return head;
        }else{
            ListNode f = dummyHead.next;
            ListNode s = f.next;
            while(s != null) {
                f.next = s.next;
                s.next = dummyHead.next;
                dummyHead.next = s;
                s = f.next;
            }
            return dummyHead.next;
        }
        // 方法2简化版方法一
//        ListNode prev = null;
//        ListNode cur = head;
//        while(cur != null) {
//            ListNode temp = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = temp;
//        }
//        return prev;
        //方法3:头插法
//        ListNode fir = new ListNode(-1);
//        //fir.next = head;
//        for (ListNode temp = head; temp != null; temp = temp.next) {
//            ListNode newNode = new ListNode(temp.val);
//            newNode.next = fir.next;
//            fir.next = newNode;
//        }
//        return fir.next;

    }

    public static void main(String[] args) {
       ListNode node1 = new ListNode(1);
       ListNode node2 = new ListNode(2);
       ListNode node3 = new ListNode(3);
       ListNode node4 = new ListNode(4);
       ListNode node5 = new ListNode(5);
       node1.next = node2;
       node2.next = node3;
       node3.next = node4;
       node4.next = node5;
       Test01 test = new Test01();
       ListNode result = Test01.reversList(node1);
       for (ListNode temp = result; temp != null; temp = temp.next) {
           System.out.print(temp.val + "->");
       }
    }
}
