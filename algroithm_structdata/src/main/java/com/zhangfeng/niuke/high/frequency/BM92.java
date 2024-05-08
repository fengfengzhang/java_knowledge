package com.zhangfeng.niuke.high.frequency;

import java.util.HashMap;
import java.util.Map;

public class BM92 {

    public int maxLength (int[] arr) {
        // write code here
        if(arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int[] dp = new int[arr.length];
        dp[0] = 1;
        map.put(arr[0],0);
        int length = 1;
        for(int i = 1; i < arr.length ; i++){
            if(!map.containsKey(arr[i])){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = Math.min(i - map.get(arr[i]),dp[i-1] + 1);
            }
            map.put(arr[i],i);
            length = Math.max(length,dp[i]);
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(new BM92().maxLength(new int[]{3,3,2,1,3,3,3,1}));
    }
}
