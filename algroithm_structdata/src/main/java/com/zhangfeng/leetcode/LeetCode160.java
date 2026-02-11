package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode160
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/11 15:52
 */
public class LeetCode160 {



      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    /**
     *
     * 相交链表
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * 图示两个链表在节点 c1 开始相交：
     *
     *
     *
     * 题目数据 保证 整个链式结构中不存在环。
     *
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;

        int lengthA = 0;
        int lengthB = 0;
        while(pointA != null){
            pointA = pointA.next;
            lengthA ++;
        }

        while(pointB != null){
            pointB = pointB.next;
            lengthB ++;
        }

        ListNode point1 = lengthA > lengthB ? headA : headB;
        ListNode point2 = lengthA > lengthB ? headB : headA;

        int sub = Math.abs(lengthA - lengthB);

        for(int i = 0; i < sub ; i++){
            point1 = point1.next;
        }

        while(point1 != point2){
            point1 = point1.next;
            point2 = point2.next;
        }

        return point1;



    }

}