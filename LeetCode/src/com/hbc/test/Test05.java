package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/7 18:02
 * @Description:
 */
public class Test05 {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

//    public static ListNode buildLinkedList(int size) {
//        ListNode myHead = new ListNode(1);
//        ListNode fir = myHead;
//        for (int i = 2; i < size+1; i++) {
//            ListNode newNode = new ListNode(i);
//            fir.next = newNode;
//            fir = fir.next;
//        }
//        return myHead;
//    }
    //打印链表
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
        // ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printNode(n1);
        System.out.println();
        //  n5.next = n6;
        deleteNode(n3);
        printNode(n1);
    }
}
