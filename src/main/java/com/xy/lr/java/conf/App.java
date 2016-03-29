package com.xy.lr.java.conf;

/**
 * Created by xylr on 16-3-25.
 */
public class App {
    public static void main(String[] args) {
        Configuration conf = Configuration.getInstance(new ConfigTest());

        System.out.println(conf.getValue("input"));
    }
}
