package com.leixindi.dao;

import com.leixindi.bean.AdminInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ����Ա�����ݷ��ʲ�ӿ�ʵ�� -- ����Ա�����ݷ���ģ��
 */
public class AdminDaoImpl implements AdminDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * ����Ա��¼�Ĳ�ѯ
     *
     * @param ad_uName ����Ա�û���
     * @param ad_pwd ����Ա����
     * @return ����Ա��Ϣ��
     * @throws Exception �׳��쳣
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
