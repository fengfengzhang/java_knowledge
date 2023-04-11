package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM71
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 20:12
 */
public class BM71 {

    /**
     * 给定一个长度为 n 的数组 arr，求它的最长严格上升子序列的长度。
     * 所谓子序列，指一个数组删掉一些数（也可以不删）之后，形成的新数组。例如 [1,5,3,7,3] 数组，其子序列有：[1,3,3]、[7] 等。但 [1,6]、[1,3,5] 则不是它的子序列。
     */

    public int LIS (int[] arr) {
        if(arr == null || arr.length == 0)return 0;
        int [] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        for(int i = 1 ; i < arr.length ; i++){
            dp[i] = 1;
            for(int j = i -1; j>=0 ;j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] +1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;

    }

    public static void main(String[] args) {
        BM71 bm71 = new BM71();
        System.out.println(bm71.LIS(new int[]{6,3,1,5,2,3,7}));
    }
}
