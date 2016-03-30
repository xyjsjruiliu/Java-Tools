package com.xy.lr.java.test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xylr on 16-3-29.
 * com.xy.lr.java.test
 */
public class Client61 {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,0};
        List list = Arrays.asList(data);
        System.out.println(list.size());
    }

    public static int max (int [] data) {
        int max = data[0];
        for(int i : data) {
            max = max > i ? max : i;
        }
        return max;
    }
}
