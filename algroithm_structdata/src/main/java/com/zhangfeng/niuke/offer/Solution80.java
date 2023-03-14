package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution79
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 12:10
 */
public class Solution80 {

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
      }

    /**
     * JZ82
     * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
     * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
     * 2.叶子节点是指没有子节点的节点
     * 3.路径只能从父节点到子节点，不能从子节点到父节点
     * 4.总节点数目为n
     */

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root == null){
            return false;
        }

        return process(root,sum);

    }

    public boolean process(TreeNode root , int sum){
          if(root.left == null && root.right == null){
              return sum == root.val;
          }
          boolean left = false;
          boolean right=false;
          if(root.left != null){
            left =  process(root.left,sum - root.val);
          }
          if(root.right != null){
            right = process(root.right,sum - root.val);
          }
          return left || right;
    }
}
