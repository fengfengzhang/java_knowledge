package com.zhangfeng.niuke.high.frequency;

/**
 * @ClassName BM20
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/9 13:26
 */
public class BM20 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
     */
    public int InversePairs(int [] array) {
         if(array == null || array.length == 0) return 0;
         return mergeSort(array,0,array.length -1);
    }

    public int mergeSort(int[] arr, int start,int end){
        if(start >= end){
            return 0;
        }

        int middle = (start +end)/2;
        int left = mergeSort(arr,start,middle) %1000000007;
        int right = mergeSort(arr,middle + 1,end)%1000000007;
        return (left + right + merge(arr,start,middle,end))%1000000007;
    }


    public int merge(int[] arr, int start,int middle,int end){
        int[] temp = new  int[end -start + 1];

        int low = start;
        int high = middle + 1;
        int index = 0;
        int res = 0;
        while (low <= middle && high <= end){
            if(arr[low] > arr[high]){
                temp[index] = arr[high ++];
                res += (middle - low + 1);
            }else{
                temp[index] = arr[low ++];
            }
            index ++;
        }


        while (low <= middle){
            temp[index ++] = arr[low++];
        }

        while (high <= end){
            temp[index++] = arr[high ++];
        }

        for(int i = 0; i < temp.length ; i++){
            arr[i + start] = temp[i];
        }
        return res %1000000007;
    }

    public static void main(String[] args) {
        BM20 bm20 = new BM20();
        System.out.println(bm20.InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
