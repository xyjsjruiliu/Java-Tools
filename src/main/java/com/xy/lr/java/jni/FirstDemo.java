package com.xy.lr.java.jni;

/**
 * Created by xylr on 16-3-11.
 */
public class FirstDemo {
    /**
     *
     */
    static{
        System.loadLibrary("firstdemo");
    }

    /**
     *
     * @return
     */
    public native int getNum();

    /**
     *
     * @return
     */
    public native String getString();

    /**
     *
     * @param args
     */
    public static void main(String []args) {
        FirstDemo demo = new FirstDemo();
        System.out.println("num:"+demo.getNum()+",string:"+demo.getString());
    }
}
