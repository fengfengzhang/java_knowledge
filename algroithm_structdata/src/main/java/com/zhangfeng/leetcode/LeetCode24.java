package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode24
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/10/15 17:27
 */
public class LeetCode24 {

    /**
     * 两两交换链表中的节点
     */

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode preNode = head;
        ListNode nextNode = head.next;
        ListNode newHead = head.next;

        ListNode point = nextNode.next;
        nextNode.next = preNode;
        preNode.next = point;
        ListNode tmpNode = preNode;
        while (point != null && point.next != null){
            preNode = point;
            nextNode = point.next;
            point = nextNode.next;
            nextNode.next = preNode;
            preNode.next = point;

            tmpNode.next = nextNode;

            tmpNode = preNode;
        }

        return newHead;

    }

    public static void main(String[] args) {
       ListNode node1 =  new ListNode(1);
       ListNode node2 =  new ListNode(2);
       ListNode node3 =  new ListNode(3);
       ListNode node4 =  new ListNode(4);
       node1.next = node2;
       node2.next = node3;
       node3.next = node4;

        ListNode node = new LeetCode24().swapPairs(node1);


    }

}