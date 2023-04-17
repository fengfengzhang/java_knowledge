package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM22
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/17 21:59
 */
public class BM22 {
    /**
     * 牛客项目发布项目版本时会有版本号，比如1.02.11，2.14.4等等
     * 现在给你2个版本号version1和version2，请你比较他们的大小
     * 版本号是由修订号组成，修订号与修订号之间由一个"."连接。1个修订号可能有多位数字组成，修订号可能包含前导0，且是合法的。例如，1.02.11，0.1，0.2都是合法的版本号
     * 每个版本号至少包含1个修订号。
     * 修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。
     */

    public int compare (String version1, String version2) {
        // write code here
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2){
            int compare = changeStrToInt(arr1[i]).compareTo(changeStrToInt(arr2[j]));
            if(compare != 0) return compare;
            i++;
            j++;
        }
        String[] str = i == len1 ?  arr2 : arr1;
        int k;
        for(k = i; k < str.length; k++){
            if(!str[k].equals("0")) break;
        }


        return k == str.length ? 0 : i == len1 ?  -1 : 1;
    }

    public Integer changeStrToInt(String str){
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) == '0'){
                i++;
            }else{
                break;
            }
        }

        return  i == str.length() ? 0 : Integer.parseInt(str.substring(i));
    }

    public static void main(String[] args) {
        BM22 bm22 = new BM22();
        System.out.println(bm22.compare("0.226","0.38"));


    }


}
