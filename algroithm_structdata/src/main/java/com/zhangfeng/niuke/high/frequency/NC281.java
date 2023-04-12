package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC281
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/12 12:43
 */
public class NC281 {

    /**
     * 剪绳子
     */

    public int cutRope(int target) {
        int[] dp = new int[target + 1];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;

        for(int i = 5; i < dp.length ; i++){
           for(int j = 1; j < i/2 + 1 ; j++){
               dp[i] = Math.max(dp[i] ,Math.max(j,dp[j]) * Math.max(i - j,dp[i-j]));
           }
        }
        return dp[target];

    }


    public int process(int target) {

        if(target == 2){
            return 1;
        }else if(target == 3){
            return 2;
        }else if(target == 4){
            return 3;
        }else{
           int max = 0;
           for(int i = 1; i< target/2+1 ; i++){
               max = Math.max(max,Math.max(i, process(i)) * Math.max(target-i, process(target -i)));
           }

           return max;
        }

    }

    public static void main(String[] args) {
        NC281 nc281 = new NC281();
        System.out.println(nc281.process(19));
        System.out.println(nc281.cutRope(19));
    }

}
