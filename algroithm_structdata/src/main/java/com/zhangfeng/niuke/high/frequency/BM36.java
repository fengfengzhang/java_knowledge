package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM36
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/30 18:45
 */
public class BM36 {

    /**
     * 判断是否为平衡二叉树
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    public class TreeInfo{
        int high;
        boolean isBalance;

        public TreeInfo(int high, boolean isBalance) {
            this.high = high;
            this.isBalance = isBalance;
        }
    }


    public TreeInfo process(TreeNode root){
        if(root == null) return new TreeInfo(0,true);

        TreeInfo leftTreeInfo = process(root.left);
        TreeInfo rightTreeInfo = process(root.right);
        if(leftTreeInfo.isBalance && rightTreeInfo.isBalance && Math.abs(leftTreeInfo.high - rightTreeInfo.high) <= 1){
            return new TreeInfo(Math.max(leftTreeInfo.high ,rightTreeInfo.high) + 1,true);
        }

        return new TreeInfo(0,false);
    }



    public boolean IsBalanced_Solution(TreeNode root) {
         return process(root).isBalance;
    }
}
