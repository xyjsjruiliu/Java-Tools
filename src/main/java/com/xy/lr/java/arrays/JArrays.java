package com.xy.lr.java.arrays;

import java.util.Arrays;

/**
 * Created by xylr on 16-3-27.
 */
public class JArrays {
    public static <T> T[] expandCapacity(T[] datas, int newLen) {
        newLen = newLen < 0 ? 0 : newLen;
        
        return Arrays.copyOf(datas, newLen);
    }

    public static void main(String[] args) {
        String str = "aad";
        System.out.println (str.intern());
    }

    /*public static <T extends Comparable> T max(T[] data) {
        T max = data[0];
        for (T i : data) {
            max = max.compareTo(i) ;
        }
        return max;
    }*/
}
