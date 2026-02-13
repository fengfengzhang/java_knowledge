package com.zhangfeng.leetcode;

/**
 *
 * @ClassName LeetCode114
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/13 10:55
 */
public class LeetCode114 {

    /**
     * 二叉树展开为链表
     *
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode preNode = null;

    public void flatten(TreeNode root) {
      if(root == null){
          return;
      }

      flatten(root.right);
      flatten(root.left);

      root.left = null;
      root.right = preNode;
      preNode = root;


    }


    public TreeNode process(TreeNode root){
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }


        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left !=null){
            root.right = left;
            root.left = null;
        }

        TreeNode leftLast = process(left);

        if(leftLast != null){
            leftLast.right = right;
            leftLast.left = null;
        }


        TreeNode rightLast = process(right);

        if(rightLast != null){
            return rightLast;
        }

        if(leftLast !=null){
            return leftLast;
        }

        return root;

    }

}