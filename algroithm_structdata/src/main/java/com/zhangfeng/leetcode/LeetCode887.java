package com.zhangfeng.leetcode;

import java.util.Arrays;

/**
 * @ClassName NC87
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/17 13:17
 */
public class LeetCode887 {
    /**
     * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
     *
     * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
     *
     * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
     *
     * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/super-egg-drop
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 从第m层仍
     * 碎  dp[i][j] = dp[i-1][m-1] + 1
     * 没碎 dp[i][j] = dp[i][j-m] + 1
     */

    public int superEggDrop (int k, int n) {
        // write code here


        int[][] dp = new int[2][n+1];
        for(int[] a : dp){
            Arrays.fill(a,0);
        }

        for(int i = 1; i< dp[0].length ;i++){
            dp[1][i] = i;
        }

        for(int i = 2 ; i <= k ; i++){
            int cur = (i&1);
            int pre =  cur == 0 ? 1 : 0;
            int m = 1;
            for(int j = 1; j<=n ; j++){
                dp[cur][j] = j; //初始化最大高度是楼层最大高度
                while (dp[pre][m-1] < dp[cur][j-m]) m ++; //随着楼层j的增大，m一定是增大的，满足条件m就++
//                for(int m = 1; m<= j ;m++){
                    dp[cur][j] = Math.min(dp[cur][j], Math.max(dp[pre][m - 1], dp[cur][j - m]) + 1);
//                }
            }
        }


        return dp[k%2][n];
    }


    public int superEggDrop2 (int k, int n) {
        // write code here


        int[][] dp = new int[k+1][n+1];
        for(int[] a : dp){
            Arrays.fill(a,0);
        }

        for(int i = 1; i< dp[0].length ;i++){
            dp[1][i] = i;
        }

        for(int i = 2 ; i < dp.length ; i++){
            int m = 1;
            for(int j = 1; j< dp[i].length ; j++){
                dp[i][j] = j; //初始化最大高度是楼层最大高度
                while (dp[i-1][m-1] < dp[i][j-m]) m ++; //随着楼层j的增大，m一定是增大的，满足条件m就++
//                for(int m = 1; m<= j ;m++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][m - 1], dp[i][j - m]) + 1);
//                }
            }
        }


        return dp[k][n];
    }

    public static void main(String[] args) {
        LeetCode887 nc87 = new LeetCode887();
        System.out.println(nc87.superEggDrop(1000000,1000000));
    }

}
