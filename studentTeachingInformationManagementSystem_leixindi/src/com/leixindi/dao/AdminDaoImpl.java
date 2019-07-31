package com.leixindi.dao;

import com.leixindi.bean.AdminInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 管理员的数据访问层接口实现 -- 管理员的数据访问模块
 */
public class AdminDaoImpl implements AdminDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * 管理员登录的查询
     *
     * @param ad_uName 管理员用户名
     * @param ad_pwd 管理员密码
     * @return 管理员信息类
     * @throws Exception 抛出异常
     */
    @Override
    public AdminInfo adminLogin(String ad_uName, String ad_pwd) throws Exception {
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(
                "select * from admininfo where ad_uname='" + ad_uName + "'AND ad_pwd= '" + ad_pwd + "'");
        AdminInfo adminInfo = new AdminInfo();
        if (resultSet.next()) {
            adminInfo.setAd_uName(resultSet.getString("ad_uName"));
            adminInfo.setAd_pwd(resultSet.getString("ad_pwd"));
            adminInfo.setAd_id(resultSet.getInt("ad_id"));
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return adminInfo;
    }
}
