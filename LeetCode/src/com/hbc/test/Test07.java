package com.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/11 0:49
 * @Description:在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 */
public class Test07 {
    public static ListNode sortList(ListNode head) {
        //归并排序
        return head == null ? null : mergeSort(head);
    }
    private static ListNode mergeSort(ListNode head)  {
        if(head.next == null){
            return head;
        }
        //通过快慢指针找中间节点
        ListNode s = head,f = head,pre = null;
        while(f != null && f.next != null) {
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        pre.next = null;//StackOverFlowError
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(s);
        return merge(l,r);
    }
    //合并
    private static ListNode merge(ListNode l,ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l != null && r != null){
            if(l.val <= r.val){
                cur.next = l;
                cur = cur.next;//
                l = l.next;
            }else{
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        //剩余值置入
        if(l != null) {
            cur.next = l;
        }
        if(r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }

    public static void printNode(ListNode node) {
        for (ListNode temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.val+"->");
        }
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printNode(sortList(n1));//结果:[2,3,6,8,9]
    }
}
