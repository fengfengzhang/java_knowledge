package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC98
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/8 13:39
 */
public class NC98 {
    /**
     * 给定彼此独立的两棵二叉树，树上的节点值两两不同，判断 t1 树是否有与 t2 树完全相同的子树。
     *
     * 子树指一棵树的某个节点的全部后继节点
     *
     * 数据范围：树的节点数满足
     * 0
     * <
     * �
     * ≤
     * 500000
     * 0<n≤500000，树上每个节点的值一定在32位整型范围内
     * 进阶：空间复杂度:
     * �
     * (
     * 1
     * )
     * O(1)，时间复杂度
     * �
     * (
     * �
     * )
     * O(n)
     */

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
      }

    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
         if(root1 != null){
          return process(root1,root2) || isContains(root1.left,root2)
             || isContains(root1.right,root2);
         }else{
             return root1 == root2;
         }
    }


    public boolean process(TreeNode node1 , TreeNode node2){
          if(node1 == null && node2 != null || node1 != null && node2 ==null) return false;
          if(node1 == node2) return true;

          return  node1.val == node2.val
                  && process(node1.left , node2.left)
                  && process(node1.right,node2.right);
    }
}
