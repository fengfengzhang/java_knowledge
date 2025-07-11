package com.zhangfeng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode39
 * @Description TODO
 * @Author zhangfeng
 * @Date 2025/7/11 14:12
 */
public class LeetCode39 {
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     */


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        process(0,target,candidates,tempList,resList,0);
        return resList;

    }

    public void process(int cur,int target,int[] candidates, ArrayList<Integer> tempList,List<List<Integer>> resList, int start){
        if(cur == target){

            List<Integer> list = new ArrayList<>(tempList);
            resList.add(list);

            return;
        }


        for(int i = start; i < candidates.length ; i++){
            if(cur + candidates[i] > target){
                break;
            }
            tempList.add(candidates[i]);
            process(cur + candidates[i],target,candidates,tempList,resList,i);
            if(!tempList.isEmpty()){
                tempList.remove(tempList.size() - 1);
            }

        }

    }


    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}