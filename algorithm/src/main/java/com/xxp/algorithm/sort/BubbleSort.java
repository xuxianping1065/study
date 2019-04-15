package com.xxp.algorithm.sort;

import javax.swing.text.Highlighter;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     *  <1>.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     *  <2>.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     *  <3>.针对所有的元素重复以上的步骤，除了最后一个；
     *  <4>.重复步骤1~3，直到排序完成。
     */
    public static void sort(long[] arr){
        int len = arr.length;
        if( len <= 1 ) return;
        //System.out.println("====排序前："+ DataHelper.arrayStr(arr));
        long startTime = System.currentTimeMillis();
        for ( int i=0; i<len; i++){
            for( int j=0; j<len-1-i; j++){
                if( arr[j] > arr[j+1]){
                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("====共耗时："+(endTime-startTime)+"毫秒");
        // System.out.println("====排序后："+ DataHelper.arrayStr(arr));
    }

    /***
     * 改进方法1：  记住上次交换的位置pos，由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可
     */
    public static void sort1(long[] arr){
        int len = arr.length;
        if( len <= 1 ) return;

        System.out.println("====改进方法1排序前："+ DataHelper.arrayStr(arr));
        long startTime = System.currentTimeMillis();
        int i = len - 1;
        while (i>1){
            int pos = 0;
            for( int j=0; j<i; j++){
                if( arr[j] > arr[j+1]){
                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    pos = j;
                }
            }
            i = pos;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("====改进方法1共耗时："+(endTime-startTime)+"毫秒");
        System.out.println("====改进方法1排序后："+ DataHelper.arrayStr(arr));
    }

    /***
     * 改进方法2：  每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者)
     */
    public static void sort2(long[] arr){
        int len = arr.length;
        if( len <= 1 ) return;

        //System.out.println("====改进方法2排序前："+ DataHelper.arrayStr(arr));
        long startTime = System.currentTimeMillis();
        int high = len -1;
        int low = 0;

        long temp;
        int j;
        while (low < high){
            for( j=low; j<high; j++){
                if( arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            --high;
            for( j=high; j>low; j--){
                if( arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            low++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("====改进方法2共耗时："+(endTime-startTime)+"毫秒");
       // System.out.println("====改进方法2排序后："+ DataHelper.arrayStr(arr));
    }

    public static void main(String[] args) {
        // 初始化数组
        long[] arr = DataHelper.initArray(10000);

        // 冒泡排序
        sort(arr);

        // 改进1
        sort1(arr);

        // 改进2
        sort2(arr);
    }
}
