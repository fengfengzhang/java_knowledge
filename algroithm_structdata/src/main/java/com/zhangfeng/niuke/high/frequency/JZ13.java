package com.zhangfeng.niuke.high.frequency;

public class JZ13 {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        process(0,0,flag,threshold);
        int max = 0;
        for(int i = 0; i < flag.length ; i++){
            for(int j = 0; j < flag[i].length; j++){
                if (flag[i][j]){
                    max++;
                }
            }
        }
        return max;

    }

    public void process(int i,int j,boolean[][] flag,int thread){
        if( i < 0 || i >= flag.length || j < 0 || j >= flag[0].length){
            return;
        }


        if(funcThread(i,j,thread)){
            return;
        }

        if(flag[i][j]) return;
        flag[i][j] = true;

        process(i -1,j,flag,thread);
        process(i+1,j,flag,thread);
        process(i,j-1,flag,thread);
        process(i,j+1,flag,thread);
    }


    public boolean funcThread(int i, int j,int thread){
        int[] arrI = getNumberArr(i);
        int[] arrJ = getNumberArr(j);
        int res = 0;
        for (int value : arrI) {
            res += value;
        }
        for (int value : arrJ) {
            res += value;
        }

        return res > thread;
    }

    public int[] getNumberArr(int num){
        String s = String.valueOf(num);
        int[] res = new int[s.length()];
        for(int i = 0; i < s.length() ; i++){
            res[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new JZ13().movingCount(10, 1, 100));
    }
}
