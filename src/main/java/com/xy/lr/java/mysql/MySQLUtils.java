package com.xy.lr.java.mysql;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.xy.lr.java.conf.ConfigTest;
import com.xy.lr.java.conf.Configuration;
import com.xy.lr.java.conf.JConstants;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by xylr on 16-3-25.
 */
public class MySQLUtils {
    //配置文件
    private static Configuration conf = null;

    private static Connection conn = null;

    /**
     * 构造函数
     */
    static {
        JConstantsMysqlPool jConstantsMysqlPool = new JConstantMysqlPoolImpl();
        conf = Configuration.getInstance(jConstantsMysqlPool);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://" + conf.getValue(jConstantsMysqlPool.getDataBaseUrl()) + ":"
                + conf.getValue(jConstantsMysqlPool.getDataBasePool())
                + "/" + conf.getValue(jConstantsMysqlPool.getDataBaseName()) + "?user="
                + conf.getValue(jConstantsMysqlPool.getDataBaseUserName()) + "&password="
                + conf.getValue(jConstantsMysqlPool.getDataBasePassword());

        try {
            conn = DriverManager.getConnection(url);
        } catch (MySQLSyntaxErrorException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("成功加载MySQL驱动");
    }

    /**
     * 创建表
     */
    /*private void createTable() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("Create table news(\n" +
                    "newID char(30) primary key,\n" +
                    "newHost char(30),\n" +
                    "newDate date,\n" +
                    "newURL char(100),\n" +
                    "newTitle char(50),\n" +
                    "News varchar(255));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 向数据库里面插入一条数据
     * @param sql
     * @return
     */
    public boolean insertData(String sql) {
        try{
            Statement stmt = conn.createStatement();
            //执行添加操作
            stmt.execute(sql);
        } catch (SQLException e){
            System.err.println("mysql insert error!");
            e.printStackTrace();
            return false;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        MySQLUtils mySQLUtils = new MySQLUtils();

        /*for(int i = 100; i < 1000000; i++) {
            boolean result = new MySQLUtils().insertData("insert into student values('"+ i + "', 24)");
        }*/
//        boolean result1 = select();
    }

    /**
     * 查询语句
     * @return
     */
    public static boolean select(String sqll) {
        String sql;
        try{
            Statement stmt = conn.createStatement();

            sql = "select * from student";
            ResultSet rs = stmt.executeQuery(sqll);
//            System.out.println("姓名\t年龄");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
            }
        } catch (SQLException e){
            System.err.println("mysql select error!");
//            e.printStackTrace();
            return false;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }
}
