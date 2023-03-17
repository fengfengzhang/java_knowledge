package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM8
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/17 14:33
 */
public class BM8 {

    /**
     * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
     * 如果该链表长度小于k，请返回一个长度为 0 的链表。
     */

      public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
      }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here

        ListNode point = pHead;
        int length = 0;
        while (point != null){
            length ++;
            point = point.next;
        }

        if(length < k) return null;

        int m = length - k;
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        point = newHead;
        for(int i = 1 ;i<= m ;i++){
            point = point.next;
        }


        return point.next;

    }



}
