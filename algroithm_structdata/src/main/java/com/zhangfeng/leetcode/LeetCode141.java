package com.zhangfeng.leetcode;

public class LeetCode141 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
       if(head == null){
           return false;
       }

       ListNode fastNode = head;
       ListNode slowNode = head;
       while (fastNode.next != null && fastNode.next.next != null){
           fastNode = fastNode.next.next;
           slowNode = slowNode.next;

           if(fastNode == slowNode){
               return true;
           }
       }

       return false;

    }


}
