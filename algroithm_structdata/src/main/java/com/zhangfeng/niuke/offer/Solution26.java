package com.zhangfeng.niuke.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName Solution26
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 18:09
 */
public class Solution26 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * JZ28
     * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
     * 例如：                                 下面这棵二叉树是对称的
     */

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        return process(pRoot,pRoot);
    }

    //一棵树中左右遍历得到的结果和另一颗树中右左遍历的结果一样
    public boolean process(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 != null && root2 == null || root1 == null || root1.val != root2.val){
            return false;
        }


        return process(root1.left,root2.right) && process(root1.right,root2.left);


    }


    public boolean process(TreeNode pRoot){
        if(pRoot == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(pRoot);
        TreeNode node;
        TreeNode tmpNode = new TreeNode(0);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size; i++){
                node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }else{
                    queue.add(tmpNode);
                }

                if(node.right != null){
                    queue.add(node.right);
                }else{
                    queue.add(tmpNode);
                }
                if(node == pRoot){
                    break;
                }

                if(!stack.isEmpty()&&stack.peek() == node.val){
                    stack.pop();
                }else{
                    stack.push(node.val);
                }

            }
            if(!stack.isEmpty()) return false;


        }
        return true;

    }
}
