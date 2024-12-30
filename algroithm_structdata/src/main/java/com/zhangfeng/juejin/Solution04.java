package com.zhangfeng.juejin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution04 {

    static int num;
    public static int solution(int[] numbers) {
        // Please write your code here

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){

            String numStr = String.valueOf(numbers[i]);
            ArrayList<Integer> itemList = new ArrayList<>();
            for(int j = 0; j < numStr.length() ; j++){
                itemList.add(Integer.valueOf(String.valueOf(numStr.charAt(j))));
            }
            list.add(itemList);
        }

        num = 0;
        process(0,numbers.length,list,new LinkedList<>());



        return num;
    }


    public static void process(int i, int k, List<ArrayList<Integer>> list, LinkedList<Integer> res){
        //此刻要进行结算
        if(i == k){
            int temp = 0;
            for(int j = 0; j < res.size() ; j++){
                temp += res.get(j);
            }
            if((temp&1) ==0){
                num ++;
            }
           /* if(!res.isEmpty()){
                res.remove(res.size() -1);
            }*/
            return;
        }


        ArrayList<Integer> bitList = list.get(i);

        for(int j = 0; j < bitList.size(); j++){
            res.addLast(bitList.get(j));
            //进行第i + 1步,第i步用了 bitList.get(j)
            process(i+1,k,list,res);
            //回退现场，要用bitList.get(j+1) 删除本次添加的
            res.removeLast();

        }

    }

    public static void main(String[] args) {
        System.out.println(Solution04.solution(new int[]{123, 456, 789}));
    }
}
