package com.zhangfeng.niuke.offer;

import java.util.ArrayList;

/**
 * @ClassName Solution4
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 17:40
 */
public class Solution4 {

    public static class ListNode {
        int val;
        ListNode next = null;

       ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * JZ6
     * 入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
         ArrayList<Integer> list = new ArrayList<>();
         if(listNode == null){
             return list;
         }

         ListNode pre = null;
         ListNode cur = listNode;
         ListNode temp;
         while (cur != null){
             temp = cur.next;
             cur.next = pre;
             pre = cur;
             cur = temp;
         }
         temp = pre;
         while (temp != null){
             list.add(temp.val);
             temp = temp.next;
         }

         return list;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        System.out.println(new Solution4().printListFromTailToHead(node1));
    }
}
