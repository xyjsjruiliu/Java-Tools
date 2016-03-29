package com.xy.lr.java.mysql;

import com.xy.lr.java.conf.*;

/**
 * Created by xylr on 16-3-25.
 */
public interface JConstantsMysqlPool extends JConstants{
    //数据库的名字
    String getDataBaseName();

    //数据库端口号
    String getDataBasePool();

    //数据库的地址
    String getDataBaseUrl();

    //数据库的用户名
    String getDataBaseUserName();

    //数据库的密码
    String getDataBasePassword();
}
