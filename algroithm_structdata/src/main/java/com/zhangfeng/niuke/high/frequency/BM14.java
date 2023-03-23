package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM14
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/23 19:11
 */
public class BM14 {


      public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
      }

    public ListNode oddEvenList (ListNode head) {
        // write code here

        ListNode evenHead = new ListNode(-1);
        ListNode oldHead = new ListNode(-1);

        ListNode point = head;
        ListNode evenPoint = evenHead;
        ListNode oldPoint = oldHead;
        ListNode temp;
        int i = 1;
        while (point != null){
            temp = point.next;
            if((i & 1) == 1){
                evenPoint.next = point;
                evenPoint = evenPoint.next;
                evenPoint.next = null;
            }else{
                oldPoint.next = point;
                oldPoint = oldPoint.next;
                oldPoint.next = null;
            }
            point = temp;
            i++;
        }

        evenPoint.next = oldHead.next;

       ListNode resNode =  evenHead.next;
        evenHead.next = null;
        oldHead.next = null;
        return resNode;
      }


}
