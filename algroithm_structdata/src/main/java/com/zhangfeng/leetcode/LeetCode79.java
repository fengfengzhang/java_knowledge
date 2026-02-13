package com.zhangfeng.leetcode;

/**
 * @ClassName LeetCode79
 * @Description TODO
 * @Author zhangfeng
 * @Date 2026/2/13 11:18
 */
public class LeetCode79 {

    /**
     * 单词搜索
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * @param board
     * @param word
     * @return
     */


    public boolean exist(char[][] board, String word) {

        boolean res = false;
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[i].length ; j ++){

                if(board[i][j] == word.charAt(0)){
                    res = process(i,j,0,word,board,flag);
                }

                if(res){
                    return true;
                }
            }
        }

        return res;

    }


    public boolean process(int i, int j ,int index, String word, char[][] board , boolean[][] flag){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j <0 || j >= board[0].length){
            return false;
        }


        if(flag[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }


        flag[i][j] = true;

        boolean res =  process(i + 1,j,index + 1,word,board,flag) ||
                process(i ,j + 1,index + 1,word,board,flag) ||
                process(i -1,j,index + 1,word,board,flag) ||
                process(i ,j - 1,index + 1,word,board,flag);

        flag[i][j] = false;

        return res;


    }

    public static void main(String[] args) {
        LeetCode79 leetCode79 = new LeetCode79();
        /*System.out.println(leetCode79.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}

        }, "SEE"));*/
        System.out.println(leetCode79.exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
                {'A'}

        }, "A"));


    }

}