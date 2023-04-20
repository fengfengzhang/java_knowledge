package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName NC378
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/20 23:25
 */
public class NC378 {

   /* public int maxXOR (ArrayList<Integer> array) {
        // write code here
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i < array.size(); i++){

            for(int j = i + 1; j < array.size(); j++){
                cur = array.get(i) ^ array.get(j);
                max = Math.max(cur,max);
            }
        }

        return max;
    }*/


    public int maxXOR (ArrayList<Integer> array) {
        if(array == null || array.size() == 0) return 0;
        NumTree numTree = new NumTree();
        numTree.insert(array.get(0));
        int max = Integer.MIN_VALUE;

        for(int i = 1; i < array.size() ; i++){
            max = Math.max(max,numTree.maxEor(array.get(i)));
            numTree.insert(array.get(i));
        }

        return max;

    }

    public static class Node{
        Node[] next = new Node[2];
    }

    public static class NumTree{
        Node head;

        public NumTree(){
            this.head = new Node();
        }

        public void insert(int num){
            Node cur = head;
            for(int i = 31 ; i>=0 ; i--){
                int index = (num >> i) &1;
                if(cur.next[index] == null){
                    cur.next[index] = new Node();
                }
                cur = cur.next[index];
            }
        }

        public int maxEor(int num){
            Node cur = head;
            int res = 0;
            for(int i= 31 ; i>= 0 ; i--){
                //这一位的值
                int path = (num >> i)&1;
                //希望走哪一条路径
                int hope = i == 31 ? path : (path ^1);
                //真实情况走了哪条路径
                int truth = cur.next[hope] == null ? (hope ^ 1) : hope;
                res |= (truth ^ path)<<i;
                cur = cur.next[truth];
            }

            return res;
        }

    }

    public static void main(String[] args) {
        NC378 nc378 = new NC378();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(nc378.maxXOR(list));
    }
}
