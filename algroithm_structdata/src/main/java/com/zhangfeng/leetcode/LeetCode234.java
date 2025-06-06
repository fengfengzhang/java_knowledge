package com.zhangfeng.leetcode;

public class LeetCode234 {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode.next != null && fastNode.next.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }


        ListNode reserve = reserve(slowNode.next);

        ListNode node1 = reserve;
        ListNode node2 = head;
        while (node1 != null){
            if(node1.val == node2.val){
                node1 = node1.next;
                node2 = node2.next;
            }else{
                break;
            }
        }


        slowNode.next = reserve(reserve);

        return node1 == null;
    }


    public ListNode reserve(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        ListNode reserve = reserve(nextNode);
        nextNode.next = head;
        head.next = null;
        return reserve;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        boolean palindrome = new LeetCode234().isPalindrome(node1);
        System.out.println(palindrome);
    }
}
