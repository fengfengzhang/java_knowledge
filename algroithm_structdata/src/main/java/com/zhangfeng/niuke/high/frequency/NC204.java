package com.zhangfeng.niuke.high.frequency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName NC204
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/31 12:32
 */
public class NC204 {

    /**
     * 给定一个二叉树，请你求出此二叉树的最大宽度。
     *
     * 本题中树第 i 层的宽度定义为：第 i 层最左边的节点到最右边之间的距离，中间空节点也计入距离。
     */

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

      public class Node{
          TreeNode treeNode;
          int pos;

          public Node(TreeNode treeNode, int pos) {
              this.treeNode = treeNode;
              this.pos = pos;
          }
      }


    public int widthOfBinaryTree (TreeNode root) {
        // write code here

        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root,1));
        Node node;
        int size;
        int max = 0;
        Node leftNode = null;
        Node rightNode = null;
        while (!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size ; i++){
                node = queue.poll();
                 if(i == 0)        leftNode = node;
                 if(i == size - 1) rightNode = node;
                 if(node.treeNode.left != null){
                     queue.offer(new Node(node.treeNode.left,node.pos * 2 -1));
                 }
                 if( node.treeNode.right != null){
                     queue.offer(new Node(node.treeNode.right,node.pos * 2));
                 }

            }
            max = Math.max(rightNode.pos - leftNode.pos + 1,max);





        }
        return max;
    }

    public static void main(String[] args) {
        NC204 nc204 = new NC204();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        System.out.println(nc204.widthOfBinaryTree(node1));
    }
}
