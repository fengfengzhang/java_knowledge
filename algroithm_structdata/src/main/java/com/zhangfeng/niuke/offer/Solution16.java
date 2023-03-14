package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution16
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 21:26
 */
public class Solution16 {
      public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
      }


    /**
     * JZ18
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
     *
     * 1.此题对比原题有改动
     * 2.题目保证链表中节点的值互不相同
     * 3.该题只会输出返回的链表和结果做对比，所以若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
     */

    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode curPoint = head;
        ListNode prePoint = tmpHead;
        while (curPoint.val != val){
            prePoint = curPoint;
            curPoint = curPoint.next;
        }

        prePoint.next = prePoint.next.next;

        return  tmpHead.next;

    }
}
