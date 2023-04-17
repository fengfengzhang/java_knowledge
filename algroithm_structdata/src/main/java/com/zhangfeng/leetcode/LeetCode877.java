package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode877
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/17 13:57
 */
public class LeetCode877 {
    /**
     * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
     *
     * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
     *
     * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
     *
     * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/stone-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean stoneGame(int[] piles) {
         int sum = 0;
         for(int i = 0; i< piles.length ; i++){
             sum += piles[i];
         }

        int process = process(piles);

         return process > (sum - process);

    }

    public int process(int[] piles){
        int[][] dp = new int[piles.length][piles.length];

        for(int j = 0; j < dp[0].length ; j++){
            for(int i = j; i >= 0 ; i--){
                if(i + 1 == j){
                    dp[i][j] = Math.max(piles[i],piles[j]);
                }else if(i == j){
                    dp[i][j]  = piles[i];
                }else{
                    dp[i][j] = Math.max(
                            piles[i] + Math.min(dp[i+2][j],dp[i+1][j-1]),
                            piles[j] + Math.min(dp[i+1][j-1],dp[i][j-2])
                    );
                }
        }

     }
      return dp[0][piles.length -1];
    }


    public int process(int[] piles,int i, int j){
        if(i == j){
            return piles[i];
        }else if(i + 1 == j){
            return Math.max(piles[i],piles[j]);
        }else{
            return  Math.max(piles[i] +
                    Math.min(process(piles,i+2,j),process(piles,i+1,j-1)),
                    piles[j] + Math.min(process(piles,i+1,j-1),process(piles,i,j-2))
                    );
        }
    }

    public static void main(String[] args) {
        LeetCode877 leetCode877 = new LeetCode877();
        System.out.println(leetCode877.stoneGame(new int[]{5,3,4,5}));
    }
}
