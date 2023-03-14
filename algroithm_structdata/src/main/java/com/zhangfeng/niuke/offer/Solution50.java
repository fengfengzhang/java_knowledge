package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution50
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/7 12:50
 */
public class Solution50 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     *
     * 数据范围： n \le 1000n≤1000
     * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
     */

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
          if(pHead1 == null || pHead2 == null){
              return null;
          }

          ListNode point1 = pHead1;
          ListNode point2 = pHead2;
          int length1 = 0;
          int length2 = 0;
          while (point1.next != null){
              length1 ++;
              point1 = point1.next;
          }
          while (point2.next != null){
              length2 ++;
              point2 = point2.next;
          }

          ListNode longListNode = length1 >= length2 ? pHead1 : pHead2;
          ListNode shortListNode = length1 >= length2 ? pHead2 : pHead1;
          point1 = longListNode;
          point2 = shortListNode;

          int sept = Math.abs(length1 - length2);
          while (point1 != null && sept != 0){
              point1 = point1.next;
              sept --;
          }

          while (point1 != null && point2 != null &&point1 != point2){
              point1 = point1.next;
              point2 = point2.next;
          }

          return  point1;

    }

    public static void main(String[] args) {
        System.out.println(new Solution50().FindFirstCommonNode(null, null));
    }

}
