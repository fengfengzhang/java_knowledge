package com.zhangfeng.leetcode;

public class LeetCode124 {
      private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      private int max;
      public int maxPathSum(TreeNode root) {
          max = Integer.MIN_VALUE;
          process(root);
          return max;
      }

      public int process(TreeNode root){
          if(root == null) return 0;

          //不必是叶子节点，当出现负数时候，先返回0
          int left = Math.max(0,process(root.left));
          int right = Math.max(0,process(root.right));

          //当前节点进行一次结算，从左到当前到右，这个子结构是否更新了最大值
          max = Math.max(max,  root.val +left + right);

          //返回给上层节点，必须是当前节点和左右子树中的一条。
          return root.val + Math.max(left,right);
      }





}
