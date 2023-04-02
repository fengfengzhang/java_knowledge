package com.zhangfeng.niuke.high.frequency;

import java.util.Arrays;

/**
 * @ClassName NC226
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/2 14:17
 */
public class NC226 {
    /**
     * 给定一个 n*m 大小的的矩阵，矩阵中由 ‘X' 和 'O' 构成，找到所有被 'X' 围绕的区域，并将其用 'X' 填充。
     */

    //标记的方式
    public char[][] surroundedArea (char[][] board) {
        // write code here
        if(board == null || board.length == 0) return board;


        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length ; i ++){
            for(int j = 0; j < board[i].length ; j++){

                for (boolean[] b : visited){
                    Arrays.fill(b,false);
                }

                if(board[i][j] == 'O' && isRender(i,j,'O',board,visited)){
                    render(i,j,board);
                }
            }
        }

        return board;

    }


    public boolean isRender(int i, int j, char preChar,char[][] board,boolean[][] vistied){
        if(preChar == 'O' && (i < 0 || i >= board.length || j < 0 || j >= board[0].length) ){
            return false;
        }
        if(vistied[i][j]) return true;
        vistied[i][j] = true;
        if(board[i][j] == 'X') return true;


      return    isRender(i-1,j,board[i][j],board,vistied) &&
                isRender(i+1,j,board[i][j],board,vistied) &&
                isRender(i,j-1,board[i][j],board,vistied) &&
                isRender(i,j+1,board[i][j],board,vistied);

    }

    public void render(int i, int j, char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(board[i][j] == 'X') return;
        board[i][j] = 'X';

        render(i + 1,j,board);
        render(i,j+1,board);
        render(i-1,j,board);
        render(i,j-1,board);
    }



    public static void main(String[] args) {
        NC226 nc226 = new NC226();
        /*char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','X','X'},
                {'X','X','O','X'},
        };*/
        char[][] board = {
                {'X','X'},
                {'O','O'},

        };

        char[][] chars = nc226.surroundedArea(board);
        for(char[] c : chars){
            System.out.println(c);
        }


    }
}
