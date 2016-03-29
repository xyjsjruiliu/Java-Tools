package com.xy.lr.java.jni;

/**
 * Created by xylr on 16-3-11.
 */
public class ShellDemo {
    static {
        System.loadLibrary("shelldemo");
    }

    public native void execShell();

    public native void execChineseProcessor(String shell);

    public static void main(String[] args) {
        ShellDemo shellDemo = new ShellDemo();
//        shellDemo.execShell();
    }
}
