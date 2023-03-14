package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution74
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 12:07
 */
public class Solution60 {

    /**
     * JZ62
     * 每年六一儿童节，牛客都会准备一些小礼物和小游戏去看望孤儿院的孩子们。其中，有个游戏是这样的：首先，让 n 个小朋友们围成一个大圈，小朋友们的编号是0~n-1。然后，随机指定一个数 m ，让编号为0的小朋友开始报数。每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，从他的下一个小朋友开始，继续0... m-1报数....这样下去....直到剩下最后一个小朋友，可以不用表演，并且拿到牛客礼品，请你试着想下，哪个小朋友会得到这份礼品呢？
     */
    public class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }



    public int LastRemaining_Solution(int n, int m) {
        if(m == 1){
            return n -1;
        }

        Node preNode = null;
        Node head = null;
        for(int i= 0; i < n ;i++){
            Node node = new Node(i);
            if(preNode == null){
                 node.next = node;
                 head = node;
            }else{
                preNode. next = node;
                node.next = head;
            }
            preNode = node;
        }


        while (preNode.next != preNode){
           for(int i = 0; i < m - 1 ;i++){
               preNode = preNode.next;
            }
            preNode.next = preNode.next.next;
        }

        return preNode.val;

    }

    public static void main(String[] args) {
        System.out.println(new Solution60().LastRemaining_Solution(5, 3));
    }


}
