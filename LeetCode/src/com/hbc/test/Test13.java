package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/21 1:21
 * @Description:对单链表进行插入排序
 */
public class Test13 {
    public static ListNode insertionSortList(ListNode head) {
        //问题？？？如何定义已知节点的前节点??不用，通过定义prev为null来实现前节点。
        // j--怎么减？？不用减，通过prev"++"即可
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode temp = null;
        ListNode prev = null;
        while(cur.next != null) {//当cur.next==null时结束
            if(cur.val <= cur.next.val){
                cur = cur.next;//若正常，不用交换
                continue;//不使用continue的话，就要用if else；否则可能出现NullPointerException
            }
            //定义后节点
            temp = cur.next;
            //肯定要移动后节点
            cur.next = temp.next;
            //循环比较之前的节点与temp值的大小，若temp大，prev后移
            prev = dummyHead;
            while(prev.next.val <= temp.val){
                prev = prev.next;
            }
            //将temp插入
            temp.next = prev.next;
            prev.next = temp;
        }
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
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        printNode(n1);
        System.out.println("\n***********");
        printNode(insertionSortList(n1));
    }

}
