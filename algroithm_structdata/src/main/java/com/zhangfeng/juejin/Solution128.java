package com.zhangfeng.juejin;

public class Solution128 {

    public static String solution(String inp) {
        // Edit your code here

        int[] dp = new int[inp.length()];
        for(int i = 0; i < inp.length(); i++){
            char pre = inp.charAt(i);
            int length = 1;
            for(int j = i+1;j < inp.length() ;j++){
                if(pre == inp.charAt(j)){
                    dp[i] = length >= 3 ? length : 0;
                    break;
                }
                length ++;
                pre = inp.charAt(j);
                if (j == inp.length() -1){
                    dp[i] = length >= 3 ? length :0;

                }
            }
        }

        int length = 0 ;
        int index = -1;

        for(int i = dp.length -1 ;i>=0 ; i--){
            if(dp[i] >= length){
                length = dp[i];
                index = i;
            }
        }

        if(length == 0){
            return inp;
        }

       return inp.substring(index,index + length);

    }

    public static void main(String[] args) {
        // Add your test cases here

        System.out.println(solution("10"));
    }
}


