package com.hbc.LinkedListTest;


/**
 * @Author: Beer
 * @Date: 2019/3/14 23:02
 * @Description:判断两链表是否相交
 */
public class Test10 {
    //方法一：指针追逐
    private static  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        //通过双指针，首先pA，pB到达底部再到另一表表头，再走，若有交点，则第二次一定相遇在交点处,则返回pA或者pB
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;//运算符顺序从前往后：== ?: =
            pB = pB == null ? headA : pB.next;
        }
        return pB;
    }

    //方法二：链表等长比较
    private static  ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = getMyLength(headA);
        int lenB = getMyLength(headB);
        //比较两链表长度，使两链表长度相等
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        //当两链表长度相等时，两头节点同时向后移，并判断其是否相同
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private static int getMyLength(ListNode head) {
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        return n;
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printNode(getIntersectionNode(n1,node1));
        printNode(getIntersectionNode2(n1,node1));

    }
}
