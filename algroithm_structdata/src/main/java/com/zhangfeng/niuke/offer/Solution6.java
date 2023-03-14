package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution6
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 18:15
 */
public class Solution6 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    /**
     * JZ8
     * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。下图为一棵有9个节点的二叉树。树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
     *
     * 输入:{8,6,10,5,7,9,11},8
     * 返回:9
     * 解析:这个组装传入的子树根节点，其实就是整颗树，中序遍历{5,6,7,8,9,10,11}，根节点8的下一个节点就是9，应该返回{9,10,11}，后台只打印子树的下一个节点，所以只会打印9，如下图，其实都有指向左右孩子的指针，还有指向父节点的指针，下图没有画出来
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //如果右子树存在，右子树，最左边就是下一个节点，如果不存在我是谁的最近左子树节点
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else{
            TreeLinkNode node = pNode;
            TreeLinkNode parent = node.next;
            while (parent != null && parent.left != node){
                node = node.next;
                parent = node.next;
            }

            return parent;
        }
    }
}
