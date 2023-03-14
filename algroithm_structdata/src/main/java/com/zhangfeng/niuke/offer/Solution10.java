package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution10
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 19:06
 */
public class Solution10 {

    /**
     * JZ12
     * 请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad
     * ⎣
     * ⎡
     * ​
     *
     * a
     * s
     * a
     * ​
     *
     * b
     * f
     * d
     * ​
     *
     * c
     * c
     * e
     * ​
     *
     * e
     * s
     * e
     * ​
     *
     * ⎦
     * ⎤
     * ​
     *   矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     * 数据范围：0 \le n,m \le 20\0≤n,m≤20 ,1\le len \le 25\1≤len≤25
     */



    public boolean hasPath (char[][] matrix, String word) {
        boolean flag = false;
        // write code here
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length ; j++){
                if(word.charAt(0) == matrix[i][j]){
                    int[][] flagMatrix = new int[matrix.length][matrix[i].length];
                    flag = process(i,j,matrix,flagMatrix,word,0);
                }

                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean process(int i , int j ,char[][] matrix, int[][] flagMatrix, String word,int index) {

        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
              return false;
          }
        if(flagMatrix[i][j] == 1){
            return false;
        }

        if(matrix[i][j] != word.charAt(index)){
              return false;
          }
        if(index == word.length() - 1){
            return true;
        }
        flagMatrix[i][j] = 1;

        boolean res =
        process(i+1,j,matrix,flagMatrix,word,index + 1)||
        process(i-1,j,matrix,flagMatrix,word,index + 1)||
        process(i,j+1,matrix,flagMatrix,word,index + 1)||
        process(i,j-1,matrix,flagMatrix,word,index + 1);

        flagMatrix[i][j] = 0;

        return res;

    }
}
