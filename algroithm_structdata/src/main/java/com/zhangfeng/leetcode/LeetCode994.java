package com.zhangfeng.leetcode;

import java.util.*;

public class LeetCode994 {

    public  class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }




    public int orangesRotting(int[][] grid) {

        Queue<Point> queue = new LinkedList<>();
        int res = -1;
        int total = 0;

        for(int i = 0; i < grid.length ;i ++){
            for(int j = 0 ;j < grid[i].length ; j++){
                if(grid[i][j] == 1){
                    total ++;
                }else if(grid[i][j] == 2){
                    Point point = new Point(i,j);
                    queue.add(point);
                }

            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            res ++;
            for(int i = 0 ;i < size; i++ ){
                Point point = queue.poll();

                if(point.x - 1 >= 0 && grid[point.x-1][point.y] == 1){
                    Point nextPoint = new Point(point.x-1, point.y);
                    queue.add(nextPoint);
                    grid[point.x-1][point.y] = 2;
                    total --;
                }

                if(point.x + 1 < grid.length && grid[point.x+1][point.y] == 1){
                    Point nextPoint = new Point(point.x+1, point.y);
                    queue.add(nextPoint);
                    total --;
                    grid[point.x+1][point.y] = 2;
                }


                if(point.y - 1 >= 0 &&grid[point.x][point.y-1] == 1){
                    Point nextPoint = new Point(point.x, point.y-1);
                    queue.add(nextPoint);
                    total --;
                    grid[point.x][point.y-1] = 2;
                }

                if(point.y + 1 < grid[0].length &&grid[point.x][point.y + 1] == 1){
                    Point nextPoint = new Point(point.x, point.y+1);
                    queue.add(nextPoint);
                    total --;
                    grid[point.x][point.y + 1] = 2;
                }

            }

        }


      if(total != 0){
          return -1;
      }
      return res == -1 ? 0 : res;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode994().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
