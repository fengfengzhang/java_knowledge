package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution82
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 12:22
 */
public class Solution82 {
    /**
     * JZ84
     * 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。
     * 1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
     * 2.总节点数目为n
     * 3.保证最后返回的路径个数在整形范围内(即路径个数小于231-1)
     *
     * 数据范围:
     * 0<=n<=10000<=n<=1000
     * -10^9<=节点值<=10^9−10
     * 9
     *  <=节点值<=10
     * 9
     *
     *
     * 假如二叉树root为{1,2,3,4,5,4,3,#,#,-1}，sum=6，那么总共如下所示，有3条路径符合要求
     */

      public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

    public int FindPath (TreeNode root, int sum) {
        // write code here
        if(root == null) return 0;

        return preProcess(root,sum);
    }

    public int preProcess(TreeNode root,int sum){
          int curNum = culFunction(root,sum);
          int leftNum = 0;
          int rightNum = 0;
          if(root.left != null){
              leftNum = preProcess(root.left,sum);
          }
          if(root.right != null){
              rightNum = preProcess(root.right,sum);
          }
          return curNum + leftNum + rightNum;
      }

    public int culFunction(TreeNode root , int sum){
          int count = sum == root.val ? 1 : 0;

          int left = 0;
          int right = 0;
          if(root.left != null){
            left = culFunction(root.left,sum - root.val);
          }
          if(root.right != null){
              right = culFunction(root.right,sum -root.val);
          }
          return count + left + right;

    }

    public static void main(String[] args) {
          TreeNode node1 = new TreeNode(1);
          TreeNode node2 = new TreeNode(2);
          TreeNode node3 = new TreeNode(3);
          TreeNode node4 = new TreeNode(4);
          TreeNode node5 = new TreeNode(5);
          node1.right = node2;
          node2.right = node3;
          node3.right = node4;
          node4.right = node5;
        Solution82 solution82 = new Solution82();
        System.out.println(solution82.FindPath(node1, 3));
    }





}
