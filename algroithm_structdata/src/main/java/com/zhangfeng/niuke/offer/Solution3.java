package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution3
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/6 17:35
 */
public class Solution3 {

    /**
     * JZ5
     * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * 数据范围:0 \le len(s) \le 1000 \0≤len(s)≤1000 。保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
     */

    public String replaceSpace (String s) {
        // write code here
        StringBuilder resBuilder = new StringBuilder();
        for(int i=0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' '){
                resBuilder.append("%20");
            }else{
                resBuilder.append(s.charAt(i));
            }
        }

        return resBuilder.toString();

    }
}
