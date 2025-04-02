package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NC42 {

    /**
     * 给出一组候选数 c 和一个目标数 t ，找出候选数中起来和等于 t 的所有组合。
     *
     * c 中的每个数字在一个组合中只能使用一次。
     *
     * 注意：
     * 1. 题目中所有的数字（包括目标数 t ）都是正整数
     * 2. 组合中的数字 (
     * a
     * 1
     * ,
     * a
     * 2
     * ,
     * …
     * ,
     * a
     * k
     * a
     * 1
     * ​
     *  ,a
     * 2
     * ​
     *  ,…,a
     * k
     * ​
     *   ) 要按非递减排序 (
     * a
     * 1
     * ≤
     * a
     * 2
     * ≤
     * …
     * ≤
     * a
     * k
     * a
     * 1
     * ​
     *  ≤a
     * 2
     * ​
     *  ≤…≤a
     * k
     * ​
     *   ).
     * 3. 结果中不能包含重复的组合
     * 4. 组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引。
     *
     * 数据范围:
     * 1
     * ≤
     * n
     * ≤
     * 70
     * 1≤n≤70 ，
     * 1
     * ≤
     * t
     * a
     * r
     * g
     * e
     * t
     * ≤
     * 100
     * 1≤target≤100 ，
     * 1
     * ≤
     * C
     * i
     * ≤
     * 50
     * 1≤C
     * i
     * ​
     *  ≤50
     * 要求：空间复杂度
     * O
     * (
     * n
     * )
     * O(n) ， 时间复杂度
     * O
     * (
     * 2
     * n
     * )
     * O(2
     * n
     *  )
     *[100,10,20,70,60,10,50],80
     *[[10,10,60],[10,20,50],[10,70],[20,60]]
     * @param num
     * @param target
     * @return
     */

    public Set<String> set;

    public ArrayList<ArrayList<Integer>> combinationSum2 (int[] num, int target) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        set  = new HashSet<>();
        Arrays.sort(num);
        process(0,num,target,list,resList);
        return resList;
    }


    public void process(int i ,int[] arr, int target, ArrayList<Integer> list ,ArrayList<ArrayList<Integer>> resList){

        //进行一次结算
        if( i == arr.length){
            int sum = 0;
            StringBuilder key = new StringBuilder();
            for(Integer num:list){
                sum += num;
                key.append(num);
                key.append("_");
            }

            if(set.contains(key.toString())){
                return;
            }

            if(sum == target){
                set.add(key.toString());
                ArrayList<Integer> temp = new ArrayList<>(list);
                resList.add(temp);
            }



            return;
        }

        //当前位置要
        list.add(arr[i]);
        process(i+1,arr,target,list,resList);
        if(!list.isEmpty()){
            list.remove(list.size() - 1);
        }
        //当前位置不要
        process(i+1,arr,target,list,resList);

    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new NC42().combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},20);
//        System.out.println(res);

        for(ArrayList<Integer> l : res){
            System.out.println(l);
        }

    }

    /**
     * 优化代码
     * public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
     *     ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
     *     Arrays.sort(num); // 排序预处理
     *     process(0, num, target, 0, new ArrayList<>(), resList);
     *     return resList;
     * }
     *
     * public void process(int index, int[] arr, int target, int currentSum,
     *                     ArrayList<Integer> list, ArrayList<ArrayList<Integer>> resList) {
     *     if (currentSum > target) return;
     *     if (currentSum == target) {
     *         resList.add(new ArrayList<>(list));
     *         return;
     *     }
     *
     *     int remainingSum = 0;
     *     for (int i = index; i < arr.length; i++) {
     *         remainingSum += arr[i];
     *     }
     *     if (currentSum + remainingSum < target) return; // 剩余和不足
     *
     *     for (int i = index; i < arr.length; i++) {
     *         if (i > index && arr[i] == arr[i - 1]) continue; // 同层去重
     *         list.add(arr[i]);
     *         process(i + 1, arr, target, currentSum + arr[i], list, resList);
     *         list.remove(list.size() - 1);
     *     }
     * }
     */

}
