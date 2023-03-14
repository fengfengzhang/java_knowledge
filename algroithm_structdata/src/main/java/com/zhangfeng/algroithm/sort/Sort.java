package com.zhangfeng.algroithm.sort;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 14:47
 */
public class Sort {


    public static void main(String[] args) {
        int[] arr = {4,6,9,7,7,2};
//        bubbleSort(arr);
//        selectSort(arr);
//        mergeSort(arr,0,arr.length -1);
//        heapSort(arr);
//        quickSort(arr,0,arr.length - 1);
//        radixSort(arr);
//        insertSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序，每次把最大的冒泡到最后位置
     */
    public static void bubbleSort(int [] arr){
         for(int i = 0; i < arr.length ; i++){
             for(int j = 0; j < arr.length - 1 -i ; j++){
                  if(arr[j] > arr[j +1]){
                      int temp = arr[j];
                      arr[j] = arr[j+1];
                      arr[j + 1] = temp;
                  }
             }
         }
    }

    /**
     * 选则排序，每次选出最小的下标和对应的位置交换
     */

    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int index = i;

            for(int j = i + 1 ; j < arr.length ; j ++){
                if(arr[index] > arr[j]){
                    index = j;
                }
            }
            if(i != index){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }

        }
    }


    /**
     * 归并排序，会额外产生数组，逐个将两个有序的数组进行合并
     */
    public static void mergeSort(int[] arr, int start,int end){
        if(start < end){
            int middle = (start + end) /2;
            mergeSort(arr,start,middle);
            mergeSort(arr,middle+1,end);
            merge(arr,start,middle,end);
        }
    }



    public static void merge(int[] arr, int start , int middle,int end){
        int[] temp = new int[end - start + 1];
        int index = 0;
        int i = start;
        int m = middle + 1;
        while (i <= middle && m <= end){
            if(arr[i] < arr[m]){
                temp[index] = arr[i];
                i ++;
            }else{
                temp[index] = arr[m];
                m ++;
            }
            index ++;
        }

        while (i <= middle){
            temp[index] = arr[i];
            index ++;
            i ++;
        }

        while (m <= end){
            temp[index] = arr[m];
            m ++;
            index ++;
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, arr, 0 + start, temp.length);
    }

    /**
     * 快速排序。选则标兵，划分。两个数组，左侧比我大右侧比我小，递归处理子数组
     */
    public static void quickSort(int[] arr, int start ,int end ){
        if(start < end){
            int low = start;
            int high = end;
            int stand = arr[start];
            while (low < high){
                while (low < high && arr[high] >= stand){
                    high --;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= stand){
                    low ++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stand;
            //low与high相等，划分成左右两个
            quickSort(arr,start,low);
            quickSort(arr,low + 1,end);
        }
    }

    /**
     * 堆排序，构建一个大顶堆，维护大顶堆的插入，取出逻辑，每次和最后一个交换位置
     */
    public static void heapSort(int[] arr){
        for(int i = 0; i < arr.length ; i++){
            heapInsert(arr,i);
        }

        for(int i = arr.length - 1; i > 0 ; i --){
            swap(arr,0,i);
            //规模小1，最大的已经找到，找第二大的
            heapChange(arr,0,i);
        }
    }

    /**
     * 插入时维护大顶堆
     */
    public static void heapInsert(int[] arr , int index){
        while (index > 0 && arr[index] > arr[(index-1) / 2]){
            swap(arr,index,(index -1)/2);
            index = (index -1)/2;
        }
    }

    /**
     * 调整大顶堆逻辑
     */
    public static void heapChange(int[] arr,int index ,int size){
        int left = index * 2 + 1;
        while (left < size){
            int largest = left + 1 < size && arr[left+1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 交换数组两个数
     */
    private static void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    /**
     * 基数排序
     * 基于桶，按照高为或者低位排
     */
    public static void radixSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length ; i++){
            max = Math.max(max,i);
        }
        if(max == Integer.MIN_VALUE){
           return;
        }

        int length = String.valueOf(max).length();
        int[] count = new int[10];
        int[][] temp = new int[10][arr.length];

        for(int i = 0, n= 1; i<length ; i++, n*=10){
            for(int j = 0; j < arr.length ; j++){
                int ys = arr[j]/n%10;
                //哪个最高为有数，
                temp[ys][count[ys]] = arr[j];
                count[ys] ++;
            }

            int index = 0;
            for(int k = 0; k < count.length ; k++){
                if(count[k] != 0){
                    for(int l = 0; l < count[k] ; l++){
                        arr[index] = temp[k][l];
                        index ++;
                    }
                    count[k] = 0;
                }
            }
        }
    }


    /**
     * 插入排序，前面已经是单调递增有序了，新来的，往前面插找到位置，在找到位置之前
     * 那些不是的位置依次往后面错一位
     */
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length  ; i++){
               if(arr[i] < arr[i-1]){
                   int temp = arr[i];
                   int j;
                   for(j = i -1 ; j >= 0 && arr[j] > temp ; j --){
                       arr[j+1] = arr[j];
                   }
                   arr[j+1] = temp;
               }
        }
    }

    /**
     * 希尔排序，步骤为d的插入排序
     */
    public static void shellSort(int[] arr){
        for(int d = arr.length/2 ; d >0 ; d/=2){

            for(int i = d ; i< arr.length ; i++){
                int j;
                if(arr[i-d] > arr[i]){
                    int temp = arr[i];
                    for(j = i -d ; j >=0 && temp < arr[j] ; j-=d){
                        arr[j+d] = arr[j];
                    }
                    arr[j+d] = temp;
                }
            }
        }
    }

}
