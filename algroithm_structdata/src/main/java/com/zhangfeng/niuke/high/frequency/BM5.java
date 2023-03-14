package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BM5
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 11:36
 */
public class BM5 {
    /**
     * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
     *
     * 数据范围：节点总数 0 \le n \le 50000≤n≤5000，每个节点的val满足 |val| <= 1000∣val∣<=1000
     * 要求：时间复杂度 O(nlogn)O(nlogn)
     */


    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
          return merge(lists,0,lists.size() - 1);
    }

    public ListNode merge(ArrayList<ListNode> lists, int l , int r){
          if(l > r){
              return null;
          }
          if(l == r){
              return lists.get(l);
          }

          ListNode node1 = merge(lists,l,(l + r)/2);
          ListNode node2 = merge(lists,(l+r)/2 + 1,r);
          return mergeTwoListNode(node1,node2);
    }


    public ListNode mergeTwoListNode(ListNode node1 , ListNode node2){
          ListNode head = new ListNode(-1);
          ListNode point1 = node1;
          ListNode point2 = node2;
          ListNode point = head;

          while (point1 != null && point2 != null){
              if (point1.val < point2.val){
                  point.next = point1;
                  point1 = point1.next;
              }else{
                  point.next = point2;
                  point2 = point2.next;
              }
              point = point.next;
          }
          while (point1 != null){
              point.next = point1;
              point1 = point1.next;
              point = point.next;
          }

          while (point2 != null){
              point.next = point2;
              point2 = point2.next;
              point = point.next;
          }

          return head.next;

    }



}
