package com.xy.lr.java.test;

import java.util.Date;
import java.util.Observable;

/**
 * Created by xylr on 16-3-25.
 */
public class Test_instanceof {
    public static void main(String[] args) {
        //String 对象是否是 Object 的实例
        boolean b1 = "String" instanceof Object;
        //String 对象是否是 String 的实例
        boolean b2 = new String() instanceof String;
        //Object 对象是否是 String 的实例
        boolean b3 = new Object() instanceof String;
        //拆箱类型是否是装箱类型的实例
//        boolean b4 = 'A' instanceof Character;
        //空对象是否是 String 的实例
        boolean b5 = null instanceof String;
        //类型转换后的对象是否是 String的实例
        boolean b6 = (String)null instanceof String;
        //Date 对象是否是 String的实例
//        boolean b7 = new Date() instanceof String;
        //在泛型类中判断 String对象是否是 Date的实例
        boolean b8 = new GenericClass<String>().isDateInstance("");
    }
}
class GenericClass<T> {
    //判断是否是 Date类型
    public boolean isDateInstance(T t) {
        return t instanceof Date;
    }
}
