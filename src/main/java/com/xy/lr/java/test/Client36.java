package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-26.
 */
public class Client36 {
    static {
        System.out.println("执行静态构造");
    }
    {
        System.out.println("执行构造代码块");
    }
    public Client36() {
        System.out.println("执行无参构造");
    }
    public Client36(String _str) {
        System.out.println("执行有参构造");
    }
    public static void main(String[] args) {
        new Client36("s");
        System.out.println();
        new Client36();
    }
}
