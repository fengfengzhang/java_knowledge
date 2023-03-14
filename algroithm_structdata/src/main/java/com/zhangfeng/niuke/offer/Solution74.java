package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution74
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 18:00
 */
public class Solution74 {

    /**
     * JZ76
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5
     *
     * 数据范围：链表长度满足 0 \le n \le 1000 \0≤n≤1000  ，链表中的值满足 1 \le val \le 1000 \1≤val≤1000
     *
     * 进阶：空间复杂度 O(n)\O(n)  ，时间复杂度 O(n) \O(n)
     *
     * 例如输入{1,2,3,3,4,4,5}时，对应的输出为{1,2,5}，对应的输入输出链表如下图所示：
     */
 public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
 }

     public ListNode deleteDuplication(ListNode pHead) {

         ListNode head = new ListNode(0);
         head.next = pHead;
         ListNode point = head;
         ListNode cur;
         int curVal;
         boolean flag = false;
         while (point.next != null){
             cur = point.next;
             curVal = cur.val;

             while (cur.next != null && curVal == cur.next.val){
                 cur = cur.next;
                 flag = true;
             }
             if(flag){
               point.next = cur.next;
             }else{
                 point = point.next;
             }
             flag = false;
         }
         return head.next;

    }

        public static void main(String[] args) {
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(3);
            ListNode node5 = new ListNode(4);
            ListNode node6 = new ListNode(4);
            ListNode node7 = new ListNode(5);
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node5;
            node5.next = node6;
            node6.next = node7;

            System.out.println(new Solution74().deleteDuplication(node1));
        }


}



