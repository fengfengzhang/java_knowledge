package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM2
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/18 17:57
 */
public class BM2 {
    /**
     * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度
     */

     public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
      }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode point = tempHead;
        ListNode pre = null;
        ListNode tempNode;
        for(int i = 0 ; i < m ; i++){
            if(i == m - 1) pre = point;
            point = point.next;
        }

        ListNode preMNode = pre;
        ListNode mNode = point;
        pre = null;
        for(int i = m ; i <= n; i++){
            tempNode = point.next;
            point.next = pre;
            pre = point;
            point = tempNode;
        }
        preMNode.next = pre;
        mNode.next = point;
        ListNode resNode = tempHead.next;
        tempHead.next = null;
        return resNode;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        BM2 bm2 = new BM2();
        bm2.reverseBetween(node1,2,4);
    }


}
