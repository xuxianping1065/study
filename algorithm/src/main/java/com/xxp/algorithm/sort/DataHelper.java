package com.xxp.algorithm.sort;

import java.util.Random;

/**
 * Created by xxp on 2019/4/14.
 */
public class DataHelper {

    /**
     * 生成指定数组长度的数组（随机数字）
     * @param length
     * @return
     */
    public static long[] initArray(int length){
        if(length<=0)return new long[0];
        long[] arr = new long[length];
        for( int i=0; i<length; i++){
            arr[i] = new Random().nextInt(length);
        }
        return  arr;
    }

    public static String arrayStr(long[] arr){
        if( arr.length <= 0 ) return "";
        StringBuffer sb = new StringBuffer();
        for(long a : arr){
            sb.append(","+a);
        }
        return sb.substring(1);
    }

}
