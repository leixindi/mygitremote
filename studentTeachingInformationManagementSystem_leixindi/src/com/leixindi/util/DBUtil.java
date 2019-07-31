package com.leixindi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库服务的通用模块
 */
public class DBUtil {

    /**
     * 获取数据库的连接
     *
     * @return 数据库连接
     * @throws Exception 异常
     */
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentTeachingInformationManagementSystem_leixindi?useSSL=false",
                "root", "19960505");
        return connection;
    }

    /**
     * 关闭数据库的相关资源
     *
     * @param connection 连接
     * @param statement 声明
     * @param resultSet  数据库结果集
     * @throws Exception 异常
     */
    public void closeDBResources(Connection connection, Statement statement, ResultSet resultSet) throws Exception {
        if (resultSet != null) {
            try {
                resultSet.close();
            } finally {
                resultSet = null;
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } finally {
                statement = null;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } finally {
                connection = null;
            }
        }
    }
}
