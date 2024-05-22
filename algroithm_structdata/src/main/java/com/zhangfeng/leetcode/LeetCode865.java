package com.zhangfeng.leetcode;

import java.util.LinkedList;

public class LeetCode865 {
    /**
     * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
     *
     * 返回包含原始树中所有 最深节点 的 最小子树 。
     *
     * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
     *
     * 一个节点的 子树 是该节点加上它的所有后代的集合。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> preQueue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()){
            size = queue.size();
            preQueue.clear();
            preQueue.addAll(queue);
            for(int i = 0; i < size ; i++){
                TreeNode treeNode = queue.removeFirst();
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }

                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }

        }

        if(preQueue.size() == 1){
            return preQueue.getFirst();
        }


      return findParentNode(root,preQueue.getFirst(),preQueue.getLast());
    }


    public TreeNode findParentNode(TreeNode root,TreeNode node1 , TreeNode node2){
        if(root == null || root == node1 || root == node2){
            return root;
        }

        TreeNode leftNode = findParentNode(root.left, node1, node2);
        TreeNode rightNode = findParentNode(root.right, node1, node2);
        if(leftNode != null && rightNode != null){
            return root;
        }
        if(leftNode == null){
            return rightNode;
        }
        return leftNode;
    }

}
