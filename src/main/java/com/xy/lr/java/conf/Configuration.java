package com.xy.lr.java.conf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by xylr on 16-3-24.
 * 配置文件类
 */
public class Configuration {
    //properties 属性
    private static Properties prop = null;
    //
    private static Configuration config = null;
    //是否导入了配置文件
    private boolean loadFlag = false;

    /**
     * 构造函数(单例)
     */
    private Configuration() {
        if (prop == null)
            prop = new Properties();
    }

    /**
     * 构造函数（单例）
     * @param filePath 文件路径
     */
    private Configuration(String filePath) {
        if (prop == null) {
            prop = new Properties();
            //导入配置文件
            loadConfig(filePath);
        }
    }

    /**
     * 通过文件路径导入配置文件
     * @param filePath 文件路径
     * @return Configuation对象
     */
    public static Configuration getInstance(String filePath) {
        if (config == null) {
            config = new Configuration(filePath);
        }
        return config;
    }

    /**
     * 通过JConstants 接口导入配置文件
     * @param jConstants 接口
     * @return Configuation对象
     */
    public static Configuration getInstance(JConstants jConstants) {
        if (config == null) {
            config = new Configuration(jConstants.getConfigPath());
        }
        return config;
    }

    /**
     *
     * @param filePath
     */
    public void loadConfig(String filePath) {
//        filePath = getFilePath(filePath);
        try {
            prop.load(new FileInputStream(filePath));
            this.loadFlag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public Object getValue(String key) {
        if (this.loadFlag) {
            return prop.get(key);
        }
        throw new NullPointerException("please load config...");
    }

    /*private String getFilePath() {
        return Thread.currentThread().getContextClassLoader().getResource("")
                .getPath().substring(1);
    }*/

    /*private String getFilePath(String fileName) {
        *//*if (System.getProperty("os.name").equals("Linux")) {
            return "/" + getFilePath() + fileName;
        }
        return getFilePath() + fileName;*//*
        return fileName;
    }*/

    @Deprecated
    protected void finalize() throws Throwable {
        System.out.println("release config ...");
        prop = null;
    }

    public static void main(String[] args) throws Throwable {
        /*System.out.println(System.getProperty("os.name"));
        ss();
        bb();*/

        Configuration conf = Configuration.getInstance("conf/config.properties");

        System.out.println(conf.getValue("input"));
    }

    /*public static void ss() throws Throwable {
        Configuration rcf = Configuration.getInstance("config.properties");
        System.out.println(rcf.getValue("MQ_url"));
    }

    public static void bb() {
        Configuration rcf2 = Configuration.getInstance("config.properties");
        System.out.println(rcf2.getValue("MQ_url"));
    }*/
}
