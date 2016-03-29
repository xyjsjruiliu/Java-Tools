package com.xy.lr.java.test;

/**
 * Created by xylr on 16-3-26.
 */
public class Client37 {
    public static void main(String[] args) {
        new Base37();
        new Base37("");
        new Base37(0);
        System.out.println(Base37.getNumOfObjects());
    }
}
class Base37{
    private static int numOfObjects = 0;
    {
        numOfObjects ++;
    }
    public Base37(){}

    public Base37(String _str) {
        this();
    }
    public Base37(int _i) {

    }
    public static int getNumOfObjects(){
        return numOfObjects;
    }
}
