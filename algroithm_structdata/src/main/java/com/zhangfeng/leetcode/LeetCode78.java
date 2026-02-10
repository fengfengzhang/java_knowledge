package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode78
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/10 11:07
 */
import java.util.*;
public class LeetCode78 {


    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        porcess(0,nums,list,tempList);
        return list;

    }


    public void porcess(int i , int[] nums ,List<List<Integer>> list , List<Integer> tempList){
        if(i == nums.length){

            List<Integer> newList = new ArrayList<>();
            newList.addAll(tempList);
            list.add(newList);
            return;

        }

        porcess(i+1,nums,list,tempList);
        tempList.add(nums[i]);
        porcess(i + 1,nums,list,tempList);
        if(!tempList.isEmpty()){
            tempList.remove(tempList.size()-1);
        }

    }


    public static void main(String[] args) {
        List<List<Integer>> subsets = new LeetCode78().subsets(new int[]{1, 2, 3});

        for (List<Integer> list : subsets){
            System.out.println(list);
        }

    }

}