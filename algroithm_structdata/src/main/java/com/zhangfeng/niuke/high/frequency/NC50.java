package com.zhangfeng.niuke.high.frequency;

import java.util.List;

/**
 * @ClassName NC50
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/16 13:02
 */
public class NC50 {

    /**
     * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     */

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
      }


    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode newHead = null;
        ListNode point = head;
        ListNode start = null;
        ListNode preReverseNode = null;
        ListNode curReverseNextNode  = null;
        while (point != null){
            start = point;

            for(int i = 1; i < k ; i++){
                point = point.next;
                if(point == null){
                    break;
                }
            }

            if(point != null){
                curReverseNextNode = point.next;
                ListNode res = reverseFromNoeToNode(start, point);
               
               if(start == head) {
                   newHead = res;
               }else{
                   preReverseNode.next = res;
               }
                preReverseNode = start;
               start.next = curReverseNextNode;
               point = curReverseNextNode;

            }else{
                break;
            }

        }

        return newHead == null ? head : newHead;
    }


    public ListNode reverseFromNoeToNode(ListNode node1 , ListNode node2){
        ListNode pre = null;
        ListNode point = node1;
        ListNode temp;
        ListNode lastNextNode = node2.next;

        while (point != lastNextNode){
            temp = point.next;
            point.next = pre;
            pre = point;
            point = temp;
        }

        return node2;
    }

    public static void main(String[] args) {
       ListNode node1 = new ListNode(1);
       ListNode node2 = new ListNode(2);
       ListNode node3 = new ListNode(3);
       ListNode node4 = new ListNode(4);
       ListNode node5 = new ListNode(5);

       node1.next = node2;
       node2.next = node3;
       node3.next = node4;
       node4.next = node5;
       NC50 nc50 = new NC50();
        ListNode point = nc50.reverseKGroup(null, 1);
       while (point != null){
           System.out.println(point.val);
           point = point.next;
       }

    }
}
