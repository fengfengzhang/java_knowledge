package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC23
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/21 13:21
 */
public class NC23 {

    /**
     * 给出一个长度为 n 的单链表和一个值 x ，单链表的每一个值为 listi ，请返回一个链表的头结点，要求新链表中小于 x 的节点全部在大于等于 x 的节点左侧，并且两个部分之内的节点之间与原来的链表要保持相对顺序不变。
     */

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode partition (ListNode head, int x) {
        // write code here

        ListNode leftNode = new ListNode(-1);
        ListNode rightNode = new ListNode(-1);

        ListNode point = head;
        ListNode leftPoint = leftNode;
        ListNode rightPoint = rightNode;
        ListNode next = null;
        while (point != null){
            next = point.next;
            if(point.val < x){
                leftPoint.next = point;
                leftPoint = leftPoint.next;
                leftPoint.next = null;
            }else{
                rightPoint.next = point;
                rightPoint = rightPoint.next;
                rightPoint.next = null;
            }
            point = next;
        }

        ListNode res = null;
        if(leftPoint != leftNode){
            leftPoint.next = rightNode.next;
            res = leftNode.next;
        }else{
            res = rightNode.next;
        }

        rightNode.next = null;
        leftNode.next = null;
        return res;
    }
}
