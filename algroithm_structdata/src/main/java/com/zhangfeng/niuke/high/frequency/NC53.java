package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC53
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 10:45
 */
public class NC53
{
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
     * 例如，
     * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
     * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
     *
     * 数据范围： 链表长度 0\le n \le 10000≤n≤1000，链表中任意节点的值满足 0 \le val \le 1000≤val≤100
     * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
     * 备注：
     * 题目保证 nn 一定是有效的
     */
    public static class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode point = head;
        int length = 0;
        while (point != null){
            length ++;
            point = point.next;
        }

        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        point = tmpHead;
        int m = length - n;
        for(int i = 1; i <= m ; i++){
            point = point.next;
        }
        point.next = point.next.next;

        return tmpHead.next;


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.val =1;
        ListNode node2 = new ListNode();
        node2.val =2;
        node1.next = node2;

        ListNode listNode = new NC53().removeNthFromEnd(node1, 1);
        System.out.println(listNode.val);
    }
}
