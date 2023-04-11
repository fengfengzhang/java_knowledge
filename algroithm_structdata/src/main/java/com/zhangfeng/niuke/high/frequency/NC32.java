package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName NC32
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/11 19:09
 */
public class NC32 {

    public int sqrt (int x) {
        // write code here

       long low = 1;
       long high = x/2 +1;
       long middle = (low + high) /2;
       while (low < high){

           if(middle * middle == x){
               return (int)middle;
           }else if(middle * middle >= x){
                high = middle - 1;
           }else{
               low = middle + 1;
           }

           middle = (low + high)/2;
       }

       if(middle * middle > x) return (int)middle -1;
       return (int)middle;

    }

    public static void main(String[] args) {
        NC32 nc32 = new NC32();
        System.out.println(nc32.sqrt(2143195649));
    }
}
