package com.hbc.test;

import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/3/4 23:26
 * @Description:
 *      给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */

public class Test02 {
    public static ListNode middleNode(ListNode head) {
        //方法一：快慢指针法

//        ListNode fast = head;
//        ListNode slow = head;
//        while(fast != null && fast.next != null) {//注意：不要遗漏fast.next != null;否则出现NullPointerException
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//       return slow;
        //方法二：普通方法
//        ListNode fir = new ListNode(-1);
//        fir.next = head;
//        int i = 0;
//        for (ListNode temp = head; temp != null; temp = temp.next) {
//            i++;
//        }
//        for (int j = 0; j < (i/2 + 1); j++) {
//            fir = fir.next;
//        }
//        return fir;
        //方法三：输出到数组
        ListNode[] arr = new ListNode[100];
        int i = 0;
        while (head.next != null) {
            arr[i++] = head;
            head = head.next;
        }
        if (i%2 == 0) {
            return arr[i/2];//arr中存放 的是单个节点（地址）
        }else{
            return arr[i/2+1];
        }
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
       // ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
      //  n5.next = n6;

        Test02 test = new Test02();
        ListNode result = test.middleNode(n1);
        printNode(result);

    }
}
