package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-24.
 */
public class App {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = count++;
        }

        System.out.println(count);
    }

    public static int mockAdd (int count) {
        //先保存初始值
        int temp = count;
        //做自增操作
        count = count + 1;
        //返回原始值
        return temp;
    }
}
