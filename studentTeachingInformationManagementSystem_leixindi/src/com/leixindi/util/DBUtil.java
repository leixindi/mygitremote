package com.leixindi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ���ݿ�����ͨ��ģ��
 */
public class DBUtil {

    /**
     * ��ȡ���ݿ������
     *
     * @return ���ݿ�����
     * @throws Exception �쳣
     */
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentTeachingInformationManagementSystem_leixindi?useSSL=false",
                "root", "19960505");
        return connection;
    }

    /**
     * �ر����ݿ�������Դ
     *
     * @param connection ����
     * @param statement ����
     * @param resultSet  ���ݿ�����
     * @throws Exception �쳣
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
