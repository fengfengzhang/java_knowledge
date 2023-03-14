package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution84
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/9 12:57
 */
public class Solution84 {

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
      }

    /**
     * JZ86
     * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
     *
     * 数据范围：树上节点数满足 1 \le n \le 10^5 \1≤n≤10
     * 5
     *    , 节点值val满足区间 [0,n)
     * 要求：时间复杂度 O(n)O(n)
     *
     * 注：本题保证二叉树中每个节点的val值均不相同。
     */

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root == null){
            return  -1;
        }

        if( root.val == o1 || root.val == o2){
            return root.val;
        }

        int left = lowestCommonAncestor(root.left,o1,o2);
        int right = lowestCommonAncestor(root.right,o1,o2);
        if(left != -1 && right != -1){
            return root.val;
        }{
            return left == -1 ? right : left;
        }

    }
}
