package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC92
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 11:38
 */
public class NC92 {
    /**
     * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
     *
     * 数据范围：0 \le |str1|,|str2| \le 20000≤∣str1∣,∣str2∣≤2000
     * 要求：空间复杂度 O(n^2)O(n
     * 2
     *  ) ，时间复杂度 O(n^2)O(n
     * 2
     *  )
     */
    public String LCS (String s1, String s2) {
        // write code here
        if(s1 == null || s2 == null || "".equals(s1) || "".equals(s2)){
            return "-1";
        }

        int[][] dp = new int[s1.length()][s2.length()];

        for(int i = 0 ;i  < s1.length() ; i++){
            if(i >= 1 && dp[i-1][0] == 1){
                dp[i][0] = 1;
                continue;
            }
            dp[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;
        }

        for(int i = 0; i < s2.length() ; i++){
            if(i >= 1 && dp[0][i-1] == 1){
                dp[0][i] = 1;
                continue;
            }
            dp[0][i] = s1.charAt(0) == s2.charAt(i) ? 1 : 0;
        }

        for(int i = 1; i < s1.length() ; i++){
            for (int j = 1; j < s2.length() ; j++){
                dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i][j-1],dp[i-1][j]));
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
            }
        }

        int length = dp[s1.length() -1][s2.length() -1];
        int i = s1.length() -1;
        int j = s2.length() -1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 && j >= 0 && length > 0){
            while (i - 1 >= 0 && dp[i-1][j] == length){
                i--;
            }

            while (j-1 >= 0 && dp[i][j-1] == length){
                j--;
            }
            stringBuilder.append(s1.charAt(i));
            i --;
            j --;
            length --;
        }

        String s = stringBuilder.reverse().toString();
        return  s.length() == 0 ? "-1" : s;

    }

    public static void main(String[] args) {
//        System.out.println(new NC92().LCS("1A2C3D4B56","B1D23A456A"));
//        System.out.println(new NC92().LCS("EKhHnp06qE75TmA7036PyZdlzad49gGNsEAe0830ozh5zKD1w3ngrA7VA0OvK15v12WzqDERP375C3NJKP934O8Ix0NF412B6Kk2hbALBzYFq66r0BuSPt1KD816nwOWB0M1dK2Cg1s9O6IfQTS0bT852U78SSjk4astw2KKvudmsavy2699Ut1DN3bp0cbJuB131j6W8L7NTf8NnfznSWtF7g3UDB9O68UXU730f02WLnPGCcHOn0SRnnuXrQ862Z77Jo24H3WAmEZG5BbKztIec1OFr7kXS54k1HBN5Mqx5f6SzL6Po3LDXmIlb613ZBozxg5c9Uc3Bnssp17E1ch2ZS5LGn4TYf2CN88J2GC43k12hV4zeg23S4D3LNM31R6R3JuoMDBwHc349pzjmb7nCxWysf9csh4vC30k5185H023UI6E2Eiwys8bhb97CoDv16X40iNgb89O0c2C4y0Ew0FoHSFyePi34s2ik9H5KFgD7aCbar29j2bNxGo7ym1xO5VQouJAhmAZhBVHF6QPspcvn90zH8B2928Lae8a6JD28z38Z56Urr1MB8753xi5NfdGqA5CekTU0MStGmDBOzTE0GAfc3ygNLLTe0rwQ2WN4rX62YiwOBkX3OUJt8IR2Z7xv6u3g0E3498072lOGX6nm6zQJsV38HN4IFL9ekbWdMEr904wkK4mbEjz0ff3NB7G1x4Q42o9X2Vj5kDuSFl7HOT8CyMzw18kVoiDj3ri0EB2zl585M93rdOlcXL1acrR4m1VmRNRkj6YOsxa7g841UG77T5e2N61iZ1375A9BMKj5Li15rNKR33dXU6dNASuEBTgL4IR347M6kK40L6ui7uLW64qIUpPZvy5s3LP9827FWJEH98aB68rhp8xqUhJ6VPv4HJudP1l5wwL7g2B2o9s9P377Ed4c24e5HmDs5RU8YbB9uCGHC5da081o4C26FhJR8NSe0tIKoHPgbq31zNEmDo1nF3l1O4aSy0LF9dfthJFy0nWzyMdCy6du3bRNF8z93MKF1bJbehe16cqHXqFJI54aE3K9h8pooBgSqG4U9FH2eZT3IB21RJH24e9lrGpE8l22WOB3WmMj806890C45Few54gN5F1jBO2Ge5KqSopHaqK2FkvVStbeFkz4p143709gLtwIiww9E2Eg9VPty7Jx7ej7nmW5rfpnfwXWiD6zNg9z7J2ybs96l23868bytw8cA0H2kAA1QOidYvrA255bAZt0x5GTIrOP5I0ynCRsT54MYiDgFkJX7I7X9F2K3n369GOl8Ih3w7vwpq4f214e2l0745K9ighL6Pz7PNCO8oP5YNQ3oHXK7HV82bUSPk19kwu8xRRp8mNBAeo2W7yMe64UQD6W95fFo1NS2Q49e958w493WVL3O2t98Au6P3z3Bifb2bmQL1GXcL9VT1X3EgnmvnN03yqGVt278KLL5rJv05U7GUFOi957m8UFn5156Bg9ZcC9OM4Y2jdI1590XO9SrOF222gG13fP9WCNZ47298lZKA5h4sA20pyDqao3PP5YCCcIfTvsYy2ZR5w93s4Y8j0as32gy0ItXOzpqyp7hzik9P958hh8rEULpx1q63bo51Y3s8jLpCusP7O34REDjmixA2s2i4wbcVVshrvio1E4dJB77r2X6J3j8oW6LfmDuDpy3xy5wnJzAwjS5T78","kQlReRfFX"));

        //前面的数右移，多少位 >> 右移，<<左移
//        System.out.println(29 << 1);
//        System.out.println(0b11111111111111111111111111111111);

        /**
         * for 循环retry ，break retry，在内层循环跳出外部循环
         */
        /*retry:
        for(int i = 0; i < 5; i++){
            System.out.println("i="+i);
            for(int j = 0 ; j < 3; j++){
                if(j==2){
                    break retry;
                }
                System.out.println("j="+j);
            }
        }*/
    }

}
