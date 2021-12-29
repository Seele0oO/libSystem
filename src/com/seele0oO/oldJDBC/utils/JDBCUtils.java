package com.seele0oO.oldJDBC.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtils {
    //构造方法私有化
    private JDBCUtils() {}
    //声明配置变量
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    //定义静态语句块
    static {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            driver=p.getProperty("driver");
            url=p.getProperty("url");
            user=p.getProperty("user");
            password=p.getProperty("password");
            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接对象
    public static Connection getConn() {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //回收资源
    public static void close(Connection conn,Statement st,ResultSet rs) {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn,Statement st) {
        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

