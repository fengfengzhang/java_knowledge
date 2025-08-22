package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode437
 * @Description 路径总和 III
 * @Author zhangfeng
 * @Date 2025/8/22 17:44
 */
public class LeetCode437 {
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


    public int pathSum(TreeNode root, int targetSum) {
        return processAll(root,targetSum);

    }


    public int processAll(TreeNode root, long targetSum){
        if(root == null){
            return 0;
        }
       return process(root, targetSum) + processAll(root.left,targetSum) +  processAll(root.right,targetSum);
    }




    public int process(TreeNode node , long targetSum){
        if(node == null){
            return 0;
        }
        int count = 0;

        if (node.val == targetSum){
            count +=   1;
        }
        count += process(node.left,targetSum - node.val);
        count +=process(node.right,targetSum - node.val);
        return count;
    }

}