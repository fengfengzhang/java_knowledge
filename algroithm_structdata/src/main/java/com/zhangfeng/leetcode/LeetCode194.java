package com.zhangfeng.leetcode;

public class LeetCode194 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == root || q == root){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftNode != null && rightNode != null){
            return root;
        }
        if(leftNode == null){
            return rightNode;
        }
        return leftNode;
    }
}
