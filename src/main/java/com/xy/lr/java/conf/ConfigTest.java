package com.xy.lr.java.conf;

/**
 * Created by xylr on 16-3-25.
 */
public class ConfigTest implements JConstants {
    public String getConfigPath() {
        return "conf/config.properties";
    }

    public String getDataBaseName() {
        return "kbase";
    }
}
