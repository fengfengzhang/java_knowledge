package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC16
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/8 13:25
 */
public class NC16 {
    /**
     * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
     * 例如：                                 下面这棵二叉树是对称的
     */

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
       return process(pRoot,pRoot);

    }

    boolean process(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 != null || node1 != null && node2 == null) return false;
        if(node1 == null && node2 == null) return true;

        return  node1.val == node2.val && process(node1.left,node2.right) && process(node1.right,node2.left);
    }
}
