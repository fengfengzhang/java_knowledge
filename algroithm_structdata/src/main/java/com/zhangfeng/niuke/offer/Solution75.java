package com.zhangfeng.niuke.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName Solution75
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 10:15
 */
public class Solution75 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
     *
     * 数据范围：0 \le n \le 15000≤n≤1500,树上每个节点的val满足 |val| <= 1500∣val∣<=1500
     * 要求：空间复杂度：O(n)O(n)，时间复杂度：O(n)O(n)
     * 例如：
     * 给定的二叉树是{1,2,3,#,#,4,5}
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

//        return functionByQueue(pRoot);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if(pRoot==null) return resList;

        Stack<TreeNode> stack1 = new Stack<>(); //l -> r
        Stack<TreeNode> stack2 = new Stack<>(); // r ->r
        Stack<TreeNode> stack = stack1;
        Stack<TreeNode> temp = stack1;
        boolean flag = true;
        stack.push(pRoot);
        while (!stack.isEmpty()){
            int size = stack.size();
            temp = flag ? stack1 : stack2;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < size ; i++){
                TreeNode node = stack.pop();
                if(flag && node.left != null) temp.push(node.left);
                if(flag && node.right != null) temp.push(node.right);
                if(!flag && node.right != null) temp.push(node.right);
                if(!flag && node.left != null) temp.push(node.left);
                list.add(node.val);
            }
            stack = temp;
            resList.add(list);
            flag = !flag;

        }
        return resList;



    }

    private ArrayList<ArrayList<Integer>> functionByQueue(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if(pRoot == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < size ; i ++){
               TreeNode treeNode = queue.poll();
               if(flag){
                   list.addLast(treeNode.val);
               }else{
                   list.addFirst(treeNode.val);
               }
               if(treeNode.left != null) queue.add(treeNode.left);
               if(treeNode.right != null) queue.add(treeNode.right);
            }
            flag = !flag;
            resList.add(new ArrayList<>(list));
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(new Solution75().Print(node1));
    }
}
