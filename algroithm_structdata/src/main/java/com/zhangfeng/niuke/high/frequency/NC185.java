package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC185
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/19 14:09
 */
public class NC185 {
    /**
     * 给定一个用 n*m 矩阵表示的群岛的地图，其中 1 表示岛屿， 0 表示海洋，每个岛屿的水平或竖直方向相邻的岛屿可以视为连在一起的岛屿，每一块岛屿视为面积为 1 ，请问面积最大的岛屿是多少。
     */
    public static int curNum;

    public int maxAreaIsland (int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        // write code here
        int max = 0;
        for (int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[i].length ; j++){
                curNum = 0;
                if(grid[i][j] == 1){
                   process(grid,i,j);
                   max = Math.max(curNum,max);
                }
            }
        }

        return max;

    }

    private void process(int[][] grid, int i, int j) {
         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
             return;
         }

         grid[i][j] = 2;
         curNum ++;
         process(grid,i+1,j);
         process(grid,i-1,j);
         process(grid,i,j+1);
         process(grid,i,j-1);
    }
}
