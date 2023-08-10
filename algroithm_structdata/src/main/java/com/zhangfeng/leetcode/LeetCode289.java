package com.zhangfeng.leetcode;

public class LeetCode289 {

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0|| board[0] == null || board[0].length == 0){
            return;
        }

        int[][] preBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length ; i++){
            for (int j = 0; j < board[i].length ; j++){
                preBoard[i][j] = board[i][j];
            }
        }


        for(int i = 0; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(isAlive(preBoard,i,j,board[i][j])){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }



    }


    public boolean isAlive(int[][] preBoard, int i, int j,int cur){
        int sum = 0;

        if(i -1 >= 0 && j -1 >=0){
            sum += preBoard[i-1][j-1];
        }

        if(i -1 >= 0){
          sum += preBoard[i-1][j];
        }

        if (i -1 >= 0 && j + 1 < preBoard[i].length){
            sum += preBoard[i-1][j+1];
        }

        if (j -1 >= 0){
            sum += preBoard[i][j-1];
        }

        if (j + 1 < preBoard[i].length){
            sum += preBoard[i][j+1];
        }

        if (i + 1 < preBoard.length && j - 1 >= 0){
            sum += preBoard[i+1][j-1];
        }
        if(i +1 < preBoard.length){
            sum += preBoard[i+1][j];
        }
        if (i+1 < preBoard.length && j + 1 < preBoard[i].length){
            sum += preBoard[i+1][j+1];
        }


        if(cur == 1){
            if(sum < 2){
                return false;
            }else if(sum == 2 || sum == 3){
                return true;
            }else{
                return false;
            }

        }else{
            if(sum == 3){
                return true;
            }else{
                return false;
            }
        }

    }
}
