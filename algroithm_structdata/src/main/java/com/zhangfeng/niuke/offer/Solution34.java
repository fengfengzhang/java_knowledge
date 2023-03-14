package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 16:21
 */
public class Solution34 {

    /**
     * JZ36
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
     *
     *
     * 数据范围：输入二叉树的节点数 0 \le n \le 10000≤n≤1000，二叉树中每个节点的值 0\le val \le 10000≤val≤1000
     * 要求：空间复杂度O(1)O(1)（即在原树上操作），时间复杂度 O(n)O(n)
     *
     * 注意:
     * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
     * 2.返回链表中的第一个节点的指针
     * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
     * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
     */

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }
     }

     //提前记录上一个节点，因为递归遍历返回的可能是null，回来时不好处理
     public TreeNode pre = null;


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
              return null;
        }
        process(pRootOfTree);
        while (pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;

    }

   public void process(TreeNode root){
         if(root == null){
             return;
         }

         process(root.left);
         root.left = pre;
         if(pre != null){
             pre.right = root;
         }

         pre = root;

         process(root.right);

   }


}
