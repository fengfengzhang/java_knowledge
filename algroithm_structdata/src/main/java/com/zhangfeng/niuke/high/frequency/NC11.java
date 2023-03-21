package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC11
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/21 19:51
 */
public class NC11 {

    /**
     * 给定一个升序排序的数组，将其转化为平衡二叉搜索树（BST）.
     */

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //每次选取中间值作为根节点 (left + right + 1) / 2  "+1"是为了最后一个元素也会被创建节点
    public TreeNode sortedArrayToBST (int[] num) {
        // write code here
        if (num == null || num.length == 0) return null;
        return process(num, 0, num.length - 1);
    }

    public TreeNode process(int[]num, int left, int right) {
        if (left > right) return null;
        if (left == right) return  new TreeNode(num[left]);

        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(num[mid]);

        TreeNode leftNode = process(num, left, mid -1);
        TreeNode rightNode = process(num, mid + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;

    }
}
