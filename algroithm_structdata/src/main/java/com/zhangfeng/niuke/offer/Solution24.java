package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution24
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/7 21:54
 */
public class Solution24 {
    /**
     * JZ26
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
     * 假如给定A为{8,8,7,9,2,#,#,#,#,4,7}，B为{8,9,2}，2个树的结构如下，可以看出B是A的子结构
     */


     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }
     }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //从当前节点开始，所有左右子数都与大树相同直到，我遍历为null为止，我就是你的子结构

        if(root1 == null || root2 == null){
            return false;
        }

        return process(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);


    }

    public boolean process(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }

        if(root1 == null){
            return false;
         }

         if(root1.val != root2.val){
             return false;
         }

         return process(root1.left,root2.left) && process(root1.right,root2.right);
    }



}
