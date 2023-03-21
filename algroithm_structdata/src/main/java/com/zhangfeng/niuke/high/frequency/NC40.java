package com.zhangfeng.niuke.high.frequency;

import java.util.Stack;

/**
 * @ClassName NC40
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/21 13:07
 */
public class NC40 {
    /**
     *假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
     * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
     */

      public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
      }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode point1 = head1;
        ListNode point2 = head2;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (point1 != null){
            stack1.push(point1);
            point1 = point1.next;
        }

        while (point2 != null){
            stack2.push(point2);
            point2 = point2.next;
        }

        int carryNum = 0;
        int val = 0;
        ListNode next = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            point1 = stack1.pop();
            point2 = stack2.pop();
            val = (point1.val + point2.val + carryNum)%10;
            carryNum = (point1.val + point2.val + carryNum) / 10;
            ListNode node = new ListNode(val);
            node.next = next;
            next = node;
        }

        Stack<ListNode> stack = stack1.isEmpty() ? stack2 : stack1;

        while (!stack.isEmpty()){
            point1 = stack.pop();
            val = (point1.val + carryNum) % 10;
            carryNum = (point1.val + carryNum) / 10;
            ListNode node = new ListNode(val);
            node.next = next;
            next = node;
        }

        if(carryNum != 0){
           ListNode node = new ListNode(carryNum);
           node.next = next;
           next = node;
        }

        return next;


      }



}
