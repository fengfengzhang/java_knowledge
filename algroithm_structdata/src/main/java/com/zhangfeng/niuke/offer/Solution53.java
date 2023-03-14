package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution53
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/7 22:04
 */
public class Solution53 {

    /**
     * JZ55
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度，根节点的深度视为 1 。
     *
     * 数据范围：节点的数量满足 0 \le n \le 1000≤n≤100 ，节点上的值满足 0 \le val \le 1000≤val≤100
     * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n)
     */

 public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     public int TreeDepth(TreeNode root) {
         if(root == null) return 0;

         return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;

     }
 }



}
