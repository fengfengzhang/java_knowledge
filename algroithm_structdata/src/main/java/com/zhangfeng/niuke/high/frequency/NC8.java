package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;

/**
 * @ClassName NC8
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 11:57
 */
public class NC8 {


     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }
     }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       ArrayList<Integer> list = new ArrayList<>();
       if(root == null) return res;
       process(root,expectNumber,list,res);
       return res;
    }

    public void process(TreeNode root, int num ,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        list.add(root.val);
        num -= root.val;
         if(root.left == null && root.right == null){
             if(num == 0){
                res.add(new ArrayList<>(list));
             }
         }

         if(root.left != null) process(root.left,num,list,res);
         if(root.right != null) process(root.right,num,list,res);

         if(list.size() !=0) list.remove(list.size() -1);
    }
}
