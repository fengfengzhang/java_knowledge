package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode92
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 18:52
 */
public class LeetCode92 {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode tempHead = new ListNode(-1);
         tempHead.next = head;
         ListNode point = tempHead;
         ListNode leftNode = null;
         ListNode rightNode = null;
         ListNode leftPre = null;
         ListNode rightNext = null;
         for(int i = 0; i < left ; i++){
             if(i == left - 1) leftPre = point;
             point = point.next;
         }
         leftNode = point;
         for(int i = 0; i < right - left; i++){
             point = point.next;
         }
            rightNode = point;

         if(rightNode == null || leftNode == null){
             return head;
         }

        rightNext = rightNode.next;

        point = leftNode;
        ListNode pre =null;
        ListNode temp;
        while (point != rightNext){
           temp = point.next;
           point.next = pre;
           pre = point;
           point = temp;
        }
        leftNode.next = rightNext;
        leftPre.next = rightNode;

        return tempHead.next;

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

        LeetCode92 leetCode92 = new LeetCode92();
        ListNode listNode = leetCode92.reverseBetween(node1, 2, 4);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }



}
