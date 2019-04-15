package com.xxp.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void sort(long[] arr) {
        int len = arr.length;
        if (len <= 0) return;
        System.out.println("====排序前：" + DataHelper.arrayStr(arr));
        long startTime = System.currentTimeMillis();

        long temp;
        int minIndex;
        for (int i = 0; i < len-1; i++) {
            minIndex = i;
            for( int j=i+1; j<len; j++){
                if( arr[j] < arr[minIndex] ){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("====共耗时：" + (endTime - startTime) + "毫秒");
        System.out.println("====排序后：" + DataHelper.arrayStr(arr));
    }

    public static void main(String[] args) {

        long[] arr = DataHelper.initArray(1000);

        sort(arr);

    }
}
