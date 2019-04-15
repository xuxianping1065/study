package com.xxp.algorithm.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void sort(long[] arr) {
        int len = arr.length;
        if (len <= 0) return;

        System.out.println("====排序前：" + DataHelper.arrayStr(arr));
        long startTime = System.currentTimeMillis();

        long temp;
        for (int i = 1; i < len; i++) {
            temp = arr[i];
            int j = i-1;
            while( j>=0 && arr[j] > temp ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

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
