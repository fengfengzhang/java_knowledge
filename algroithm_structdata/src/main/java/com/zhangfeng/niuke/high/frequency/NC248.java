package com.zhangfeng.niuke.high.frequency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NC248
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/2 15:32
 */
public class NC248 {
    /**
     * 计算给定二叉树的左叶子之和。
     *
     * 树上叶子节点指没有后继节点的节点，左叶子指连向父节点的左侧的叶子节点。
     */

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }


      public class Node{
          TreeNode treeNode;
          int isSource; //1左2右

          public Node(TreeNode treeNode, int isSource) {
              this.treeNode = treeNode;
              this.isSource = isSource;
          }
      }

    public int sumOfLeftLeaves (TreeNode root) {
        // write code here

        if(root == null) return 0;
        Node node = new Node(root,1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int sum = 0;
        Node poll;
        while (!queue.isEmpty()){
             poll = queue.poll();
             if(poll.treeNode.left != null){
                 queue.offer(new Node(poll.treeNode.left,1));
             }

             if(poll.treeNode.right != null){
                 queue.offer(new Node(poll.treeNode.right,2));
             }

             if(poll.treeNode.left == null && poll.treeNode.right == null&& poll.isSource == 1){
                 sum += poll.treeNode.val;
             }
        }

        return sum;


    }
}
