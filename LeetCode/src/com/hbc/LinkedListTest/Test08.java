package com.hbc.LinkedListTest;

/**
 * @Author: Beer
 * @Date: 2019/3/12 0:47
 * @Description:
 *      编写代码，以给定值x为基准将链表分割成两部分，所有小于x的
 * 结点排在大于或等于x的结点之前
 *      给定一个链表的头指针 ListNode* pHead，请返回重新排列后的
 * 链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Test08 {
    public static ListNode partition(ListNode pHead, int x) {
        if (pHead == null &&pHead.next == null){
            return pHead;
        }
        ListNode maxHead = new ListNode(-1);
        ListNode minHead = new ListNode(-1);
        ListNode l = maxHead;
        ListNode s = minHead;
        ListNode cur = pHead;
        while(cur != null) {
            if (cur.val >= x) {
                l.next = cur;
                l = l.next;
                cur = cur.next;
            }else {
                s.next = cur;
                s = s.next;
                cur = cur.next;
            }
        }
        s.next = maxHead.next;
        l.next = null;
        return minHead.next;

    }

    public static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val+"->");
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
        printNode(partition(n1,5));
    }
}
