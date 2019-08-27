package com.hbc.LinkedListTest;


/**
 * @Author: Beer
 * @Date: 2019/8/27 21:13
 * @Description: 合并K个有序链表
 *
 *      采用归并思想
 */

public class Test17 {

    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(5);
        node01.next = node02;

        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(6);
        node11.next = node12;

        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(8);
        node21.next = node22;
        node22.next = node23;
        ListNode[] lists = {node01,node11,node21};
        printNode(mergeKLists(lists));//1->3->3->4->5->6->8


    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return solve(lists, 0, lists.length - 1);
    }

    public static ListNode solve(ListNode[] arr, int l, int r) {
        if (l == r) return arr[l];

        int mid = (l + r) >> 1;

        ListNode lNode = solve(arr, l, mid);
        ListNode rNode = solve(arr, mid + 1, r);

        return merge(lNode, rNode);
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        }else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }

    private static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
        }
    }
}
