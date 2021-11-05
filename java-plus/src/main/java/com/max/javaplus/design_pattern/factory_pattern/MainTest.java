package com.max.javaplus.design_pattern.factory_pattern;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className apply_test
 * @date 2021/11/5 14:26
 * @desc 实际应用
 **/
public class MainTest {

    /**
     * JDK中Calender的getInstance
     **/
    @Test
    public void test01(){
        // 简单工厂方法
        Calendar.getInstance();
    }

    /**
     * JDBC的Connection对象的获取
     **/
    @Test
    public void test02() throws SQLException, ClassNotFoundException {
        // 准备连接数据库
        String driverClass = "org.mariadb.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://192.168.1.222:3306/lidomtech_erp_dev?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String user = "developer";
        String password = "developer";

        // 加载数据库驱动程序(对应的 Driver 实现类中有注册驱动的静态代码块)
        Class.forName(driverClass);
        // 通过 DriverManager 的 getConnection() 方法获取数据库连接
        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

        System.out.println(connection);
    }

    @Test
    public void test03(){

        int  a = 5 > 4 ? 1 : 0;
        System.out.println(a);

    }
}
