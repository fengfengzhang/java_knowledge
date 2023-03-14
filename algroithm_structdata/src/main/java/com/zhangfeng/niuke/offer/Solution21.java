package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution21
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 12:02
 */
public class Solution21 {
    /**
     * JZ23
     * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
     *
     * 数据范围： n\le10000n≤10000，1<=结点值<=100001<=结点值<=10000
     * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
     *
     * 例如，输入{1,2},{3,4,5}时，对应的环形链表如下图所示：
     */

     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
          if(pHead == null || pHead.next == null){
              return null;
          }
          ListNode low = pHead;
          ListNode fast = pHead;

          while (fast!=null){
              if(fast.next == null){
                  break;
              }
              low = low.next;
              fast = fast.next.next;
              if(fast == low){
                  break;
              }
          }

          if(fast == null) return null;

          low = pHead;
          while (low != fast){
              fast = fast.next;
              low = low.next;
          }

          return fast;

    }

}
