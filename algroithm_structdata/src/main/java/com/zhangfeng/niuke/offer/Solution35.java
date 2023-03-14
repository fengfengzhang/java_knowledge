package com.zhangfeng.niuke.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution35
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/11 16:01
 */
public class Solution35 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    /**
     * JZ37
     * 请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束，但要求能够根据序列化之后的字符串重新构造出一棵与原二叉树相同的树。
     *
     * 二叉树的序列化(Serialize)是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#）
     *
     * 二叉树的反序列化(Deserialize)是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     */

    String Serialize(TreeNode root) {
        if(root == null) return "#";
        //记录空节点
        TreeNode node = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder resBuilder = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            resBuilder.append(treeNode == node ? "#" : treeNode.val);
            resBuilder.append(",");
            if(treeNode == node) continue;
            TreeNode leftNode = treeNode.left == null ? node : treeNode.left;
            queue.add(leftNode);
            TreeNode rightNode = treeNode.right == null ? node : treeNode.right;
            queue.add(rightNode);
        }
        return resBuilder.toString();
    }

    TreeNode Deserialize(String str) {
        String[] valArr = str.split(",");
        if(valArr[0].equals("#")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 1;
        TreeNode root = new TreeNode(Integer.parseInt(valArr[0]));
        queue.add(root);
        while (index < valArr.length && !queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            String left = valArr[index++];
            String right = valArr[index++];

            if(!left.equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                treeNode.left = leftNode;
                queue.add(leftNode);
            }else{
                treeNode.left = null;
            }

            if(!right.equals("#")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                treeNode.right = rightNode;
                queue.add(rightNode);
            }else{
                treeNode.right = null;
            }

        }
        return root;
    }


}
