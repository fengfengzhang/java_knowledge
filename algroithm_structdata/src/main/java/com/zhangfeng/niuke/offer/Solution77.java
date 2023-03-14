package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution77
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/10 11:00
 */
public class Solution77 {

    /**
     * 描述
     * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     * 样例解释：
     */

    public static class TreeNode {
        int val = 0;
       TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class TreeMessage{
        int high;
        boolean isBalanced;

        public TreeMessage(int high, boolean isBalanced) {
            this.high = high;
            this.isBalanced = isBalanced;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
         return process(root).isBalanced;
    }

    public TreeMessage process(TreeNode root){
        if(root == null) return  new TreeMessage(0,true);

        TreeMessage left = process(root.left);

        TreeMessage right = process(root.right);

        return  new TreeMessage(Math.max(left.high,right.high) + 1,(left.isBalanced && right.isBalanced && (Math.abs(left.high - right.high) <=1)));
    }

    private boolean isBalancedByHigh(TreeNode root) {
        if(root == null ) return true;

        boolean left = IsBalanced_Solution(root.left);

        boolean right = IsBalanced_Solution(root.right);

        return  (Math.abs(getHigh(root.left) - getHigh(root.right))) <= 1 && left && right;
    }

    public int getHigh(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(getHigh(root.left),getHigh(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(new Solution77().IsBalanced_Solution(node1));
    }
}
