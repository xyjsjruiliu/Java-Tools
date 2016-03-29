package com.xy.lr.java.jni;

/**
 * Created by xylr on 16-3-11.
 *
 */
public class ChineseInfoXtract4j {

    /**
     * ChineseInfoXtract processor for java
     * @param processor 执行命令
     */
    public static native void ChineseProcessor(String processor);

    /**
     * 导入动态链接库
     */
    static {
        System.loadLibrary("chineseInfoXtract4j");
    }

    public static void main(String[] args) {
        ChineseInfoXtract4j.ChineseProcessor("ls");
    }
}
