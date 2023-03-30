package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM36
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/30 18:28
 */
public class BM34 {
    /**
     * 判断是否为二叉搜索树
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
        int minValue;
        int maxValue;
        boolean isSearch;

        public TreeInfo(int minValue, int maxValue, boolean isSearch) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.isSearch = isSearch;
        }
    }

    public TreeInfo process(TreeNode root){
        if(root == null ) return new TreeInfo(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        TreeInfo leftTreeInfo = process(root.left);
        TreeInfo rightTreeInfo = process(root.right);

        if(leftTreeInfo.isSearch && rightTreeInfo.isSearch &&
                leftTreeInfo.maxValue < root.val && root.val < rightTreeInfo.minValue){

            return new TreeInfo(
                    Math.min(Math.min(root.val,leftTreeInfo.minValue), rightTreeInfo.minValue),
                    Math.max(Math.max(root.val,leftTreeInfo.maxValue),rightTreeInfo.maxValue),
                    true
                    );
        }

        return new TreeInfo(0,0,false);

    }

    public boolean isValidBST(TreeNode root) {
         return process(root).isSearch;

    }

}
