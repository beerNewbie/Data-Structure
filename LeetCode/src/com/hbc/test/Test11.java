package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/16 16:06
 * @Description:找环形链表中环的第一个节点的值
 */
public class Test11 {
    //方法一：通过快慢指针追逐法,当二者追上时，创建新指针，当新指针与慢指针相遇时就为环的第一个节点
    private static  ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        boolean hasCycle = false;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (f == s) {
                hasCycle = true;
                break;
            }
        }
        ListNode node = head;
        if (hasCycle) {
            while (node != s) {
                node = node.next;
                s = s.next;
            }
            return node;
        }else {
            return null;
        }
    }

    private static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val+"->");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        System.out.println(detectCycle(n1).val);
    }

}
