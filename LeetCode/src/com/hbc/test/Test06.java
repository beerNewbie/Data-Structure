package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/7 23:30
 * @Description:删除单链表的节点
 */
public class Test06 {
    //1.通过被给定的节点
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    //2.通过给定的值
    public static ListNode removeElements(ListNode head, int val) {
        //方法1;虚拟头结点法
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        while(prev.next != null) {
//            if (prev.next.val == val) {
//                prev.next = prev.next.next;
//            }else {
//                prev = prev.next;
//            }
//        }
//        return dummyHead.next;
        //方法2：
        //先判断头结点是否 为给定值
        if (head !=  null && head.val == val) {
            head = head.next;
        }
        //判断头结点是否为空
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while(prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;

        
    }

    public static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val+"->");
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        deleteNode(n2);
        printNode(n1);
        System.out.println();
        ListNode result = removeElements(n1,1);
        printNode(result);

    }
}
