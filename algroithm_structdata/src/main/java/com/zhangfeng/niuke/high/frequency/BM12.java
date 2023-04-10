package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM12
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/10 16:57
 */
public class BM12 {

    /**
     * 单链表排序
     */

      public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val){
            this.val = val;
        }
      }

    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null) return head;

        ListNode low = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }

        ListNode middle = low.next;
        low.next = null;
        ListNode leftNode = sortInList(head);
        ListNode rightNode = sortInList(middle);
        ListNode headTemp = new ListNode(0);
        ListNode point = headTemp;
        while (leftNode != null && rightNode!=null){
            if(leftNode.val < rightNode.val){
                point.next = leftNode;
                leftNode = leftNode.next;
            }else{
                point.next = rightNode;
                rightNode = rightNode.next;
            }

            point = point.next;
            point.next = null;
        }


        if(leftNode == null){
            point.next = rightNode;
        }else{
            point.next = leftNode;
        }

        return headTemp.next;


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        BM12 bm12 = new BM12();
        ListNode listNode = bm12.sortInList(node1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
