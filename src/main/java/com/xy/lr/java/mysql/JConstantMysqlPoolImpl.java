package com.xy.lr.java.mysql;

import com.xy.lr.java.conf.JConstants;

/**
 * Created by xylr on 16-3-25.
 */
public class JConstantMysqlPoolImpl implements JConstantsMysqlPool {
    public String getDataBaseName() {
        return "DataBaseName";
    }

    public String getDataBasePool() {
        return "DataBasePool";
    }

    public String getDataBaseUrl() {
        return "DataBaseUrl";
    }

    public String getDataBaseUserName() {
        return "DataBaseUserName";
    }

    public String getDataBasePassword() {
        return "DataBasePassword";
    }

    public String getConfigPath() {
        return "conf/config.properties";
    }
}
