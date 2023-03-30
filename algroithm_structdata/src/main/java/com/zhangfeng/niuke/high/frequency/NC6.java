package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC6
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/30 21:19
 */
public class NC6 {

    /**
     * 二叉树里面的路径被定义为:从该树的任意节点出发，经过父=>子或者子=>父的连接，达到任意节点的序列。
     * 注意:
     * 1.同一个节点在一条二叉树路径里中最多出现一次
     * 2.一条路径至少包含一个节点，且不一定经过根节点
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public  int max = Integer.MIN_VALUE;

    public int maxPathSum (TreeNode root) {
        // write code here
         if(root == null) return 0;
         max = root.val;
         process(root);
         return max;

    }

    private int process(TreeNode root) {
        if(root == null) return 0;

        int leftValue = process(root.left);
        int rightValue = process(root.right);

        max = Math.max(leftValue + root.val + rightValue,max);

        return  Math.max(Math.max(root.val, root.val + leftValue), root.val + rightValue);
    }

    public static void main(String[] args) {
        /*  TreeNode node1 = new TreeNode(-20);
          TreeNode node2 = new TreeNode(8);
          TreeNode node3 = new TreeNode(20);
          TreeNode node4 = new TreeNode(15);
          TreeNode node5 = new TreeNode(6);
          node1.left = node2;
          node1.right = node3;
          node3.left = node4;
          node3.right = node5;*/

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;


          NC6 nc6 = new NC6();
          nc6.maxPathSum(node1);
        System.out.println(nc6.max);
    }
}
