package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC195
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/30 21:44
 */
public class NC195 {
    /**
     * 给定一颗二叉树，求二叉树的直径。
     * 1.该题的直径定义为：树上任意两个节点路径长度的最大值
     * 2.该题路径长度定义为：不需要从根节点开始，也不需要在叶子节点结束，也不需要必须从父节点到子节点，一个节点到底另外一个节点走的边的数目
     * 3.这个路径可能穿过根节点，也可能不穿过
     * 4.树为空时，返回 0
     */
      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

     public int maxDiameter;

     public class TreeInfo{
          int high;
          int diameter;

         public TreeInfo(int high, int diameter) {
             this.high = high;
             this.diameter = diameter;
         }
     }

    public int diameterOfBinaryTree (TreeNode root) {
        // write code here
        if(root == null) return 0;
        process(root);
        return maxDiameter;
    }


    public TreeInfo process (TreeNode root) {
        // write code here
        if(root == null) return new TreeInfo(0,0);

        TreeInfo leftTreeInfo = process(root.left);
        TreeInfo rightTreeInfo = process(root.right);

        int diameter  = Math.max(Math.max(leftTreeInfo.diameter,rightTreeInfo.diameter),leftTreeInfo.high+rightTreeInfo.high);
        maxDiameter = Math.max(maxDiameter,diameter);

        return new TreeInfo(Math.max(leftTreeInfo.high,rightTreeInfo.high) + 1,diameter);

    }




}
