package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC109
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/19 14:04
 */
public class NC109 {

    /**
     * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
     * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数
     */
    public int solve (char[][] grid) {
        // write code here
        int sum = 0;

        for(int i = 0; i < grid.length ; i ++){
            for (int j = 0; j < grid[i].length ; j++){
                if(grid[i][j] == '1'){
                    sum ++;
                    process(grid,i,j);
                }
            }
        }
        return sum;

    }

    private void process(char[][] grid, int i , int j) {
        if(i < 0 || j <0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }

        grid[i][j] = '2';
        process(grid,i+1,j);
        process(grid,i,j+1);
        process(grid,i-1,j);
        process(grid,i,j-1);
    }
}
