package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution25
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 17:56
 */
public class Solution25 {
    /**
     * JZ27
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 数据范围：二叉树的节点数 0 \le n \le 10000≤n≤1000 ， 二叉树每个节点的值 0\le val \le 10000≤val≤1000
     * 要求： 空间复杂度 O(n)O(n) 。本题也有原地操作，即空间复杂度 O(1)O(1) 的解法，时间复杂度 O(n)O(n)
     */
      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }


    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        process(pRoot);
        return pRoot;
    }

    public void process(TreeNode pRoot){
        if(pRoot == null)
            return ;

        TreeNode left = pRoot.left;
        TreeNode right =pRoot.right;

        pRoot.left = right;
        pRoot.right = left;

        process(left);
        process(right);

    }
}
