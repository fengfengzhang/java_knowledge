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
        int minHight;
        int maxHight;
        boolean isSearch;

        public TreeInfo(int minHight, int maxHight, boolean isSearch) {
            this.minHight = minHight;
            this.maxHight = maxHight;
            this.isSearch = isSearch;
        }
    }

    public TreeInfo process(TreeNode root){
        if(root == null ) return new TreeInfo(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        TreeInfo leftTreeInfo = process(root.left);
        TreeInfo rightTreeInfo = process(root.right);

        if(leftTreeInfo.isSearch && rightTreeInfo.isSearch &&
                leftTreeInfo.maxHight < root.val && root.val < rightTreeInfo.minHight){

            return new TreeInfo(
                    Math.min(Math.min(root.val,leftTreeInfo.minHight), rightTreeInfo.minHight),
                    Math.max(Math.max(root.val,leftTreeInfo.maxHight),rightTreeInfo.maxHight),
                    true
                    );
        }

        return new TreeInfo(0,0,false);

    }

    public boolean isValidBST(TreeNode root) {
         return process(root).isSearch;

    }

}
