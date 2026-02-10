package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode25
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/10 16:56
 */
public class LeetCode25 {
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */

     public static class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        ListNode point = head;
        ListNode tail = point;
        while (point != null) {

            int i;
            for (i = 0; i < k-1 && tail != null; i++) {
                tail = tail.next;
            }
            if(tail == null){
                return hair.next;
            }

            ListNode tailNext = tail.next;



            ListNode[] reverseNodes = reverse(point,tail);

            pre.next = reverseNodes[0];
            pre = reverseNodes[1];

            tail = tailNext;
            point = tailNext;
            pre.next = point;

        }

        return hair.next;

    }

    public ListNode[] reverse(ListNode head, ListNode tail){
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        ListNode tNode = tail.next;
        while(nextNode != tNode){
            ListNode temp = nextNode.next;
            nextNode.next =  curNode;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
            nextNode = temp;
        }


        return new ListNode[] {tail,head};
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new LeetCode25().reverseKGroup(node1,2);
    }
}
