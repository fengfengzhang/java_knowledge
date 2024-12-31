package com.zhangfeng.juejin;


public class Solution38 {

    /**
     * 小U计划进行一场从地点A到地点B的徒步旅行，旅行总共需要 M 天。为了在旅途中确保安全，小U每天都需要消耗一份食物。在路程中，小U会经过一些补给站，这些补给站分布在不同的天数上，且每个补给站的食物价格各不相同。
     *
     * 小U需要在这些补给站中购买食物，以确保每天都有足够的食物。现在她想知道，如何规划在不同补给站的购买策略，以使她能够花费最少的钱顺利完成这次旅行。
     *
     * M：总路程所需的天数。
     * N：路上补给站的数量。
     * p：每个补给站的描述，包含两个数字 A 和 B，表示第 A 天有一个补给站，并且该站每份食物的价格为 B 元。
     * 保证第0天一定有一个补给站，并且补给站是按顺序出现的。
     * @param m
     * @param n
     * @param p
     * @return
     */

    public static int solution(int m, int n, int[][] p) {
        // Edit your code here

        //途径第i个补给站，形成j天的最小代价
        int[][] dp = new int[n][m];
        for(int i = 0; i < dp[0].length ; i++){
            dp[0][i] = (i + 1) * p[0][1];
        }

        for(int j = 0; j < dp.length ; j++){
            dp[j][0] = p[0][1];
        }

        for(int i = 1; i < dp.length ;i ++){
            for(int j = 1; j< dp[i].length ; j++){
                //第j天时候，没有补给站出现此时 最小代价为 经过 i-1个补给站行走j天的代价
                if(p[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //出现了，选择不用，经过i-1个补给站 行走j天的花费
                    //出现了，选择用则 经过i-1个补给站 行走了j-1天的花费或者是经过i个补给站行走了j-1天 +上最后一个补给站的花费
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1] + p[i][1]),dp[i][j-1] + p[i][1]);
                }
            }
        }



        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 4, new int[][]{{0, 2}, {1, 3}, {2, 1}, {3, 2}}));


    }



}
