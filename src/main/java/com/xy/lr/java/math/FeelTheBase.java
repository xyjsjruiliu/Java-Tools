package com.xy.lr.java.math;

/**
 * Created by xylr on 16-3-15.
 * 进制转换类
 */
public class FeelTheBase {
    /**
     * 把十进制数转换成二进制数
     * @param i 十进制数字
     * @return 二进制数字
     */
    public static String intToBinary(int i){
        return Integer.toBinaryString(i);
    }

    /**
     * 把十进制数转换成十六进制数
     * @param i 十进制数字
     * @return 十六进制数字
     */
    public static String intToHex(int i) {
        return Integer.toHexString(i);
    }

    /**
     * 把十进制数转换成八进制数
     * @param i 十进制数字
     * @return 八进制数字
     */
    public static String intTiOctal(int i) {
        return Integer.toOctalString(i);
    }

    /**
     * 把十六进制数字转成十进制数字
     * @param s 十六进制数字
     * @return 十进制数字
     */
    public static int hexToInt(String s) {
        return Integer.valueOf(s, 16);
    }

    /**
     * 把八进制数字转成十进制数字
     * @param s 八进制数字
     * @return 十进制数字
     */
    public static int octalToInt(String s) {
        return Integer.valueOf(s, 8);
    }

    /**
     * 把二进制数字转成十进制数字
     * @param s 二进制数字
     * @return 十进制数字
     */
    public static int binaryToInt(String s) {
        return Integer.valueOf(s, 2);
    }

    /**
     * 把十进制数转换成二进制数
     * @param l 十进制数字
     * @return 二进制数字
     */
    public static String longToBinary(long l) {
        return Long.toBinaryString(l);
    }

    /**
     * 把十进制数转换成十六进制数
     * @param l 十进制数字
     * @return 十六进制数字
     */
    public static String longToHex(long l) {
        return Long.toHexString(l);
    }

    /**
     * 把十进制数转换成二进制数
     * @param l 十进制数字
     * @param length 生成的二进制数字的位数
     * @return 二进制数字
     */
    public static String longToBinary(long l, int length) {
        String binary = longToBinary(l);
        //如果设定的位数小于二进制数字，则不做任何的操作
        if(binary.length() >= length) {
            return binary;
        } else{
            String temp = "";
            //给二进制数添加多余的0
            for(int i = 0; i < length - binary.length(); i++)
                temp += "0";
            return temp + binary;
        }
    }

    public static void main(String[] args) {
//        String a = Integer.toBinaryString(4);
        System.out.println(longToBinary(8L, 2));
    }
}
