package com.zhangfeng.niuke.high.frequency;

import java.util.Stack;

/**
 * @ClassName BM13
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/28 20:55
 */
public class BM13 {

    /**
     *给定一个链表，请判断该链表是否为回文结构。
     * 回文是指该字符串正序逆序完全一致。
     */


      public class ListNode {
        int val;
        ListNode next = null;
      }

    public boolean isPail (ListNode head) {
        // write code here

        if(head == null || head.next == null) return true;


        Stack<Integer> stack = new Stack<>();
        ListNode point = head;
        while (point !=null){
             stack.push(point.val);
             point = point.next;
        }
        point = head;
        while (point != null && !stack.isEmpty()){
            if(point.val != stack.peek()){
                return false;
            }
            point = point.next;
            stack.pop();
        }
        return true;


    }
}
