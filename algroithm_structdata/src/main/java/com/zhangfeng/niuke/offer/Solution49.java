package com.zhangfeng.niuke.offer;

/**
 * @ClassName Solution49
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 16:03
 */
public class Solution49 {
    /**
     * JZ51
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P mod 1000000007
     *
     * 数据范围：  对于 50\%50% 的数据, size\leq 10^4size≤10
     * 4
     *
     * 对于 100\%100% 的数据, size\leq 10^5size≤10
     * 5
     *
     * 数组中所有数字的值满足 0 \le val \le 10^90≤val≤10
     * 9
     *
     *
     * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
     */

    public int InversePairs(int [] array) {
        if(array == null) return 0;
        return  mergeSort(array,0,array.length - 1);
    }

    public int mergeSort(int[] arr,int start,int end){
        if(start<end){
            int middle = (start+end)/2;
            int left = (mergeSort(arr,start,middle) % 1000000007) ;
            int right = (mergeSort(arr,middle+1,end) %1000000007);
            return  (left + right + merge(arr,start,middle,end))%1000000007;
        }else{
            return 0;
        }
    }

    public int merge(int[] arr ,int start, int middle,int high){
        int[] temp = new int[high - start + 1];
        int i = start;
        int j = middle + 1;
        int index = 0;
        int pair = 0;
        while (i <= middle && j <= high){
            if(arr[i] > arr[j]){
                temp[index++] = arr[j];
                j++;
                pair += middle - i + 1;
                pair %= 1000000007;
            }else{
                temp[index++] = arr[i];
                i++;
            }
        }

        while (i<=middle){
            temp[index++] = arr[i];
            i++;
        }
        while (j<=high){
            temp[index++] = arr[j];
            j++;
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, arr, start + 0, temp.length);

        return pair;

    }

    public static void main(String[] args) {
        System.out.println(new Solution49().InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
