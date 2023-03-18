package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM9
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/18 17:56
 */
public class BM9 {

    //给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
      public class ListNode {
        int val;
        ListNode next = null;
      }
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode point = head;
        int length = 0;
        while (point != null){
            point = point.next;
            length ++;
        }

        if(length < n) return head;

        int m = length - n + 1;

        ListNode tempHead = new ListNode();
        tempHead.next = head;
         point = tempHead;
        int i = 0;
        while (i < m-1 && point != null){
            point = point.next;
            i++;
        }

        if(i == m-1 && point.next != null) {
            point.next = point.next.next;
        }

        ListNode res = tempHead.next;
        tempHead.next = null;
        return res;
    }
}
