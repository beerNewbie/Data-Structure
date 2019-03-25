package com.hbc.LinkedListTest;

/**
 * @Author: Beer
 * @Date: 2019/3/26 0:21
 * @Description:旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 */
public class Test14 {
    public static ListNode rotateRight(ListNode head, int k) {
        //方法一：
        // //问题？？如何让链表成环？直接使temp到尾部并使temp.next=head；
        // //如何将环断开？定义prev、cur使prev=head，cur=head.next，当cur到指定位置时使prev.next=null；
        // if(head == null || head.next == null){
        //     return head;
        // }
        // ListNode dummyHead = new ListNode(0);
        // dummyHead.next =  head;
        // ListNode temp = head;
        // int count = 1;
        // //将链表循环，并求出链表长度
        // while(temp.next != null){
        //     count++;
        //     temp = temp.next;
        // }
        // temp.next = head;
        // //去掉多余的循环次数
        // k %= count;
        // int step = count - k;
        // System.out.println(k+" "+step);
        // //找到头结点后断开
        // ListNode prev = head;
        // ListNode cur = head.next;
        // while(step != 1){
        //     prev = prev.next;
        //     cur = cur.next;
        //     step--;
        // }
        // prev.next = null;
        // return cur;
        //方法二：双指针法
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = head,cur = head;
        int len = 1;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        k %= len;
        int step = len - k - 1;
        while(step != 0){
            cur = cur.next;
            step--;
        }
        temp.next = dummyHead.next;//注意：一定要是temp.next不能是temp
        dummyHead.next = cur.next;
        cur.next = null;
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
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println("原链表：");
        printNode(n1);
        System.out.println("\n变换后：");
        printNode(rotateRight(n1,2));
    }
}
/**
 * 结果：
 * 原链表：
 * 8->3->6->4->5
 * 变换后：
 * 4->5->8->3->6
 */
