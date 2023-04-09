package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM1
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/9 13:15
 */
public class BM1 {
    /**
     * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
     */
    public static  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {

        if(head == null || head.next == null) return head;
        if(head.next.next == null){
            ListNode next = head.next;
            next.next = head;
            head.next = null;
            return next;
        }else{
           ListNode next = head.next;
           ListNode res = ReverseList(head.next);
           next.next = head;
           head.next = null;
           return res;

        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        BM1 bm1 = new BM1();
        ListNode listNode = bm1.ReverseList(node1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }
}
