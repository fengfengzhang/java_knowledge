package com.zhangfeng.niuke.high.frequency;


public class NC88 {

    /**
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
     *
     * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
     * 要求：时间复杂度
     * 𝑂
     * (
     * 𝑛
     * 𝑙
     * 𝑜
     * 𝑔
     * 𝑛
     * )
     * O(nlogn)，空间复杂度
     * 𝑂
     * (
     * 1
     * )
     * O(1)
     * 数据范围：
     * 0
     * ≤
     * 𝑛
     * ≤
     * 1000
     * 0≤n≤1000，
     * 1
     * ≤
     * 𝐾
     * ≤
     * 𝑛
     * 1≤K≤n，数组中每个元素满足
     * 0
     * ≤
     * 𝑣
     * 𝑎
     * 𝑙
     * ≤
     * 10000000
     * 0≤val≤10000000
     * @param a
     * @param n
     * @param K
     * @return
     */

    public int findKth (int[] a, int n, int K) {
        for(int i = 0; i < a.length ; i++){
            heapInsert(a,i);
        }
        int t = 0;
        for(int i = a.length - 1; i > 0 ; i --){
            swap(0,i,a);
            //规模小1，最大的已经找到，找第二大的
            heapChange(a,0,i);
            t ++;
            if(t == K) break;
        }

        return a[a.length - K ];


    }


    public void heapChange(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while (left < size){
            int largest = left + 1 < size && arr[left+1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(largest,index,arr);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public  void heapInsert(int[] arr , int index){
        while (index > 0 && arr[index] > arr[(index-1) / 2]){
            swap(index,(index -1)/2,arr);
            index = (index -1)/2;
        }
    }

    public void swap(int i,int j , int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new NC88().findKth(new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663}, 49, 24));
    }


}
