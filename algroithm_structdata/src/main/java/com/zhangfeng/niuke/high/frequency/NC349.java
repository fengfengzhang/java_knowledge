package com.zhangfeng.niuke.high.frequency;

import java.util.ArrayList;

/**
 * @ClassName NC349
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/17 17:44
 */
public class NC349 {
    /**
     * 数组小和的定义如下
     *
     * 例如，数组 s = [1, 3, 5, 2, 4, 6] ，在 s[0] 的左边小于或等于 s[0] 的数的和为 0 ； 在 s[1] 的左边小于或等于 s[1] 的数的和为 1 ；在 s[2] 的左边小于或等于 s[2] 的数的和为 1+3=4 ；在 s[3] 的左边小于或等于 s[3] 的数的和为 1 ；
     * 在 s[4] 的左边小于或等于 s[4] 的数的和为 1+3+2=6 ；在 s[5] 的左边小于或等于 s[5] 的数的和为 1+3+5+2+4=15 。所以 s 的小和为 0+1+4+1+6+15=27
     * 给定一个数组 s ，实现函数返回 s 的小和
     */
    public long calArray (ArrayList<Integer> nums) {
        // write code here
        long[] arr = nums.stream().mapToLong(Long::valueOf).toArray();
        long sum = mergeSort(arr,0,arr.length -1);
        return sum;
    }


    public long mergeSort(long[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) /2;
            long left = mergeSort(arr,start,mid);
            long right = mergeSort(arr,mid+1,end);
            long sum = merge(arr,start,mid,end);
            return left + right + sum;
        }else {
            return 0;
        }
    }


    public long merge(long[] arr , int start,int mid ,int end){
        int i = start;
        int j = mid + 1;
        long[] temp = new long[end - start + 1];
        int index = 0;
        long sum = 0;
        while ( i <= mid && j <= end){
            if(arr[i]<= arr[j]){
                sum += arr[i] * (end - j + 1);
                temp[index] = arr[i];
                i ++;
            }else{
                temp[index] = arr[j];
                j++;
            }
            index ++;
        }

        while (i <= mid){
            temp[index++] = arr[i++];
        }

        while (j <= end){
            temp[index ++] = arr[j++];
        }

        for(int m = 0 ; m < temp.length ; m++){
            arr[start + m] = temp[m];
        }
        return sum;
    }

}
