package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC162
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 12:06
 */
public class NC162 {
    /**
     * 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。
     * 1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
     * 2.总节点数目为n
     * 3.保证最后返回的路径个数在整形范围内(即路径个数小于231-1)
     */

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

    public int FindPath (TreeNode root, int sum) {
        // write code here
        return culAllNode(root,sum);
    }


    public int culAllNode(TreeNode root, int sum){
        if(root == null) return 0;

      return   culAllNode(root.left,sum) + culAllNode(root.right,sum)
        + process(root,sum);
    }


    public int process(TreeNode root,int sum){

        int cur = 0;
        int left = 0;
        int right = 0;
        if(root != null && root.val == sum){
            cur = 1;
        }
        if(root.left != null){
            left = process(root.left,sum - root.val);
        }
        if(root.right != null){
            right = process(root.right,sum - root.val);
        }

        return cur + left + right;

    }




}
