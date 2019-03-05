package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/5 22:52
 * @Description:单链表的回文结构
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900
 */

public class Test03 {
    public static boolean chkPalindrome(ListNode head) {
        //方法一：直接反转链表法
//        if (head == null){
//            return true;
//        }else {
//            //进行链表反转
//            ListNode fre = new ListNode(-1);
//            for (ListNode temp = head; temp != null; temp = temp.next) {
//                ListNode newNode = new ListNode(temp.val);
//                newNode.next = fre.next;
//                fre.next = newNode;
//            }//注意反转后是fre.next
//            //进行比较
//            while(head != null) {
//                if(head.val != fre.next.val) {
//                    return false;
//                }
//                head = head.next;
//                fre.next = fre.next.next;
//            }
//            return true;
//        }
        //方法二：暴力解法：找中间值再反转链表
        if (head == null && head.next == null) {
            return true;
        }
        //用快慢指针法找找中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast.next = fast.next.next;
        }
        ListNode mid = slow;
        //再求后半段的反转链表(三指针法）
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = mid;
        if (mid.val == head.val) {
            return true;
        } else {
            if (mid.next == null) {
                return false;
            } else {
                ListNode f = dummyHead.next;
                ListNode s = f.next;
                while (f != null) {
                    f.next = s.next;
                    s.next = dummyHead.next;
                    dummyHead.next = s;
                    s = f.next;
                }
                //在遍历进行比较
                while (dummyHead.next != null && head != null) {
                    if (dummyHead.next.val != head.val) {
                        return false;
                    }
                    head = head.next;
                    dummyHead.next = dummyHead.next.next;
                }
                return true;
            }


        }
    }

        public static void main (String[]args){
            ListNode n1 = new ListNode(6);
            ListNode n2 = new ListNode(5);
            ListNode n3 = new ListNode(1);
            ListNode n4 = new ListNode(5);
            ListNode n5 = new ListNode(6);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            Test03 test = new Test03();
            System.out.println(Test03.chkPalindrome(n1));
        }

    }