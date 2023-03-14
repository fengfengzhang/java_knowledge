package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution12
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 19:48
 */
public class Solution12 {
    /**
     * JZ14
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ），每段绳子的长度记为 k[1],...,k[m] 。请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18 。
     */
    public int cutRope1(int target) {
        if(target == 2){
            return 1;
        }else if(target == 3){
            return 2;
        }else{
            int max= 0;
            for(int i = 1; i < target/2  ; i++){
                 max =  Math.max(Math.max(cutRope1(i),i) * Math.max(cutRope1(target-i),target-i),max);
            }
            return max;
        }
    }


    public int cutRope(int target){
        if(target <= 3){
            return target -1;
        }
        int [] dp = new int[target + 1];
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4 ; i <= target ; i++){

            dp[i] = 0;
            for(int j = 1; j <= i/2 ; j++){
                dp[i] = Math.max(Math.max(j,dp[j]) * Math.max(i-j,dp[i-j]),dp[i]);
            }
        }

        return dp[target];

    }
}
