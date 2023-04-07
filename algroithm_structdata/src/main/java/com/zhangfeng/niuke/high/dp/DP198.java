package com.zhangfeng.niuke.high.dp;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName DP198
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/7 11:11
 */
public class DP198 {
    /**
     * 给定一个二叉树，确定他是否是一个完全二叉树。
     *
     * 完全二叉树的定义：若二叉树的深度为 h，除第 h 层外，其它各层的结点数都达到最大个数，第 h 层所有的叶子结点都连续集中在最左边，这就是完全二叉树。（第 h 层可能包含 [1~2h] 个节点）
     */


      public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }


    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        boolean flagNode = false;
        while (!queue.isEmpty()){
            node = queue.poll();

            if(flagNode && (node.left != null || node.right != null)){
                return false;
            }

            if(node.left == null && node.right !=  null){
                return false;
            }


            //以后的节点都是叶子节点
            if(!flagNode && (node.left != null && node.right == null || node.left == null && node.right == null)){
                flagNode = true;
            }

            if(node.left != null){
                queue.offer(node.left);
            }

            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        DP198 dp198 = new DP198();

        System.out.println(dp198.isCompleteTree(node1));
    }
}
