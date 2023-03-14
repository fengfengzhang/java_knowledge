package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution11
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 19:24
 */
public class Solution11 {
    /**
     * ZJ13
     * 地上有一个 rows 行和 cols 列的方格。坐标从 [0,0] 到 [rows-1,cols-1] 。一个机器人从坐标 [0,0] 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 threshold 的格子。 例如，当 threshold 为 18 时，机器人能够进入方格   [35,37] ，因为 3+5+3+7 = 18。但是，它不能进入方格 [35,38] ，因为 3+5+3+8 = 19 。请问该机器人能够达到多少个格子？
     */

    public int movingCount(int threshold, int rows, int cols) {
        int[][] flagMatrix = new int[rows][cols];
        process(flagMatrix,0,0,rows,cols,threshold);
        int sum = 0;
        for(int i = 0; i< flagMatrix.length ; i++){
            for (int j = 0 ; j < flagMatrix[i].length; j++){
                if(flagMatrix[i][j] == 1) sum ++;
            }
        }
        return sum;

    }

    private void process(int[][] flagMatrix, int i, int j, int rows, int cols, int threshold) {
        if(!isAllow(i,j,rows,cols,threshold)){
            return;
        }
        if(flagMatrix[i][j] == 1){
            return;
        }
        flagMatrix[i][j]  = 1;
        process(flagMatrix,i+1,j,rows,cols,threshold);
        process(flagMatrix,i-1,j,rows,cols,threshold);
        process(flagMatrix,i,j+1,rows,cols,threshold);
        process(flagMatrix,i,j-1,rows,cols,threshold);

    }

    public boolean isAllow(int i , int j ,int rows ,int clos,int threshold){
        if(i < 0 || i >= rows || j < 0 || j >= clos){
            return false;
        }

        int sum = 0;
        while (i != 0){
           sum += i %10;
           i = i /10;
        }
        while ( j != 0){
            sum += j%10;
            j = j /10;
        }

        return threshold >= sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution11().movingCount(1, 2, 3));
    }
}
