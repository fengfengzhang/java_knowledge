package com.zhangfeng.leetcode;

public class LeetCode543 {
    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     *
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     *
     * 两节点之间路径的 长度 由它们之间边数表示。
     */

     public class TreeNode {
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


  public static int MaxDiameter;


  public class TreeInfo {
      public int  diameter;
      public int  high;

      public TreeInfo(int diameter, int high) {
          this.diameter = diameter;
          this.high = high;
      }
  }


    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        MaxDiameter = 0;

        process(root);

        return MaxDiameter;

    }


    public TreeInfo process(TreeNode root){
       if(root == null){
           return new TreeInfo(0,0);
       }

       TreeInfo leftTreeInfo = process(root.left);
       TreeInfo rightTreeInfo = process(root.right);

        int diameter  = Math.max(Math.max(leftTreeInfo.diameter,rightTreeInfo.diameter),leftTreeInfo.high+rightTreeInfo.high);
        MaxDiameter = Math.max(MaxDiameter,diameter);
        int high =  Math.max(leftTreeInfo.high,rightTreeInfo.high)+1;
       TreeInfo treeInfo = new TreeInfo( diameter,high);
       return treeInfo;
    }







}
