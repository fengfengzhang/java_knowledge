package com.zhangfeng.leetcode;

public class LeetCode200 {

    /**
     *给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length ; i ++){
            for (int j = 0; j< grid[i].length ; j++){
                if(grid[i][j] == '1'){
                    res ++;
                    process(grid,i,j);
                }
            }
        }

        return res;

    }


    public void process(char[][] grid,int i,int j){
        if(i < 0 || j <0 || i >= grid.length || j >= grid[0].length ){
            return;
        }
        if(grid[i][j] == '0' || grid[i][j] == '2'){
            return;
        }

        grid[i][j] = '2';


        process(grid,i-1,j);
        process(grid,i+1,j);
        process(grid,i,j-1);
        process(grid,i,j+1);

    }
}
