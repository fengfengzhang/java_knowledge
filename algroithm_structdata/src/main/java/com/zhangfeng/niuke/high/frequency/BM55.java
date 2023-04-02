package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;

/**
 * @ClassName BM55
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/2 12:25
 */
public class BM55 {

    /**
     * 给出一组数字，返回该组数字的所有排列
     * 例如：
     * [1,2,3]的所有排列如下
     * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
     * （以数字在数组中的位置靠前为优先级，按字典序排列输出。
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
//        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        process(0,num,list);
        return list;

    }


    public void process(int i , int[] num,ArrayList<ArrayList<Integer>> list){
        if(i == num.length){
            ArrayList<Integer> item = new ArrayList<>();
            for(int j = 0; j < num.length ; j++){
                item.add(num[j]);
            }

            list.add(item);

            return;


        }

        for(int j = i ; j < num.length ; j++){
            swap(i,j,num);
            process(i+1,num,list);
            swap(i,j,num);
        }
    }

    private void swap(int i, int j, int[] num) {
         int temp = num[i];
         num[i] = num[j];
         num[j] = temp;
    }

    public static void main(String[] args) {
        BM55 bm55 = new BM55();
        System.out.println(bm55.permute(new int[]{1, 2, 3}));
    }

}
