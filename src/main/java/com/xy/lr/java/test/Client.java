package com.xy.lr.java.test;

import java.util.Scanner;

/**
 * Created by xylr on 16-3-24.
 */
public class Client {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int ii = input.nextInt();
            System.out.println("\n====" + ii + " 的相等判断====");
            Integer i = new Integer(ii);
            Integer j = new Integer(ii);
            System.out.println("new产生的对象：" + (i == j));

            i = ii;
            j = ii;
            System.out.println("基本类型转换的对象：" + (i == j));

            i = Integer.valueOf(ii);
            j = Integer.valueOf(ii);
            System.out.println("valueOf产生的对象：" + (i == j));
        }

        /*Server s= new SimpleServer(1000);*/

//        System.out.println(10.00 - 9.60);

        /*Scanner input = new Scanner(System.in);
        System.out.print("请输入多个数字判断奇偶：");
        while(input.hasNextInt()) {
            int i = input.nextInt();
            String str = i + "->" + (i % 2 == 1 ? "奇数" : "偶数");
            System.out.println(str);
        }*/

        /*int fee = 200;
        saveDefault:save(200);*/
    }

    static void saveDefault() {}
    static void save(int fee){}
}
