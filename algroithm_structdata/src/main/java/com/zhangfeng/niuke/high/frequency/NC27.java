package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NC27 {
    /**
     * 描述
     * 现在有一个没有重复元素的整数集合S，求S的所有子集
     * 注意：
     * 你给出的子集中的元素必须按升序排列
     * 给出的解集中不能出现重复的元素
     *
     * 数据范围：
     * 1
     * ≤
     * 𝑛
     * ≤
     * 5
     * 1≤n≤5，集合中的任意元素满足
     * ∣
     * 𝑣
     * 𝑎
     * 𝑙
     * ∣
     * ≤
     * 10
     * ∣val∣≤10
     * 要求：空间复杂度
     * 𝑂
     * (
     * 𝑛
     * !
     * )
     * O(n!)，时间复杂度
     * 𝑂
     * (
     * 𝑛
     * !
     * )
     * O(n!)
     */

    public ArrayList<ArrayList<Integer>> subsets (int[] S) {
        // write code here

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(S);
        for(int i = 0; i <= S.length; i++){
            process(S,0,i,res);
        }

        return res;
    }


    public void process(int[] arr,int i,int length,ArrayList<ArrayList<Integer>> res){
        if(i == length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int k = 0; k < length ;k ++){
                list.add(arr[k]);
            }

            Collections.sort(list);

            if(!res.contains(list)){
                res.add(list);
            }
            return;
        }

        for(int k = i ; k < arr.length ; k++){
            swap(arr,i,k);
            process(arr,i+1,length,res);
            swap(arr,k,i);
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        NC27 nc27 = new NC27();
        System.out.println(nc27.subsets(new int[]{1, 2, 3}));
    }
}
