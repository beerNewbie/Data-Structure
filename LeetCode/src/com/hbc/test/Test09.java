package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/12 14:26
 * @Description:
 *   在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Test09 {
    public static ListNode deleteDuplication(ListNode pHead)
    {

        //方法一：使用 递归，先判断呢是否有值相同，有就跳过相同的值
        // 并return deleteDuplication(pNode),否则return deleteDuplication(pHead.next)
//        //有值相等时
//        if(pHead == null || pHead.next == null){
//            return pHead;
//        }
//        if (pHead.val == pHead.next.val) {
//            ListNode pNode = pHead.next;
//            //跳过值相等的节点
//            while (pNode != null && pHead.val == pNode.val) {
//                pNode = pNode.next;
//            }
//            return deleteDuplication(pNode);
//        }else {
//            pHead.next = deleteDuplication(pHead.next);
//            return pHead;
//        }

        //方法二:暴力求解法
//        if(pHead == null || pHead.next == null){
//            return pHead;
//        }
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = pHead;
//        ListNode prev = dummyHead;
//        ListNode cur = pHead;
//        while (cur != null && cur.next != null) {
//            if (cur.val == cur.next.val) {
//                //判断是否有两个以上连在一起
//                while (cur.next != null && cur.val == cur.next.val) {
//                    cur.next = cur.next.next;
//                }
//                prev.next = cur.next;//头去掉再向后移
//                cur = cur.next;
//            }else {
//                prev = cur;//整体向后移
//                cur = cur.next;
//            }
//        }
//        return dummyHead.next;

        //方法三：剑指offer解法
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode pre = null;
        ListNode cur = pHead;
        while (cur != null) {
            boolean isNeedDel = false;
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                isNeedDel = true;
            }
            if (!isNeedDel) {
                pre = cur;
                cur = cur.next;
            }else {
                ListNode toBeDel = cur;
                while (toBeDel != null && cur.val == toBeDel.val) {
                    next = toBeDel.next;
                    toBeDel = next;
//                    toBeDel = toBeDel.next;
//                    next = toBeDel.next;
                }
                if (pre == null) {
                    pHead = next;
                }else {
                    pre.next = next;
                }
                cur = next;
            }
        }
        return pHead;


    }
    

    public static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val+"->");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        printNode(n1);
        System.out.println("\n***********");
        printNode(deleteDuplication(n1));
    }

}
