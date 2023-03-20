package com.zhangfeng.niuke.high.frequency;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName DP13
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/20 18:01
 */
public class DP13 {

    /**
     * 棋盘上 A点有一个过河卒，需要走到目标 B点。卒行走的规则：可以向下、或者向右。同时在棋盘上 C 点有一个对方的马，该马所在的点和所有跳跃一步可达的点称为对方马的控制点。因此称之为“马拦过河卒”。
     *
     * 棋盘用坐标表示，A 点 (0, 0)、B点(n,m)，同样马的位置坐标是需要给出的。
     * 现在要求你计算出卒从 A点能够到达 B点的路径的条数，假设马的位置(x,y)是固定不动的，并不是卒走一步马走一步。
     */

    public static boolean check(int x, int y,int i, int j){
        return (Math.abs(i-x) + Math.abs(j - y) == 3) && (x != i && y != j) || (x==i && y ==j);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long[][] dp = new long[n + 1][m + 1];

        for(int i = 0; i < dp.length ; i++){
            if(check(x,y,i,0)){
               break;
            }
            dp[i][0] = 1;
        }
        for(int i = 0; i < dp[0].length ; i++){
            if(check(x,y,0,i)){
                break;
            }
            dp[0][i] = 1;
        }

        for(int i =1; i < dp.length ; i++){
            for(int j = 1; j < dp[i].length ; j++){
                if(check(x,y,i,j)){
                    continue;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }

        System.out.println(dp[n][m]);


    }
}
