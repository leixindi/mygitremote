package com.leixindi.dao;

import com.leixindi.bean.TeacherInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ʦ��Ϣ�����ݷ��ʲ�ӿ�ʵ�� -- ��ʦ��Ϣ�����ݷ���ģ��
 */
public class TeacherDaoImpl implements TeacherDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * ��ӽ�ʦ��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int addTeaInfo(TeacherInfo teacherInfo) throws Exception {
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        int rows = statement.executeUpdate(
                "INSERT INTO teacherinfo(tea_uname, tea_pwd, tea_name, tea_major, tea_createdate, " +
                        "tea_updatedate, ad_id) values ('" + teacherInfo.getTea_uName() + "','" +
                        teacherInfo.getTea_pwd() + "','" + teacherInfo.getTea_name() + "','" +
                        teacherInfo.getTea_major() + "','" + teacherInfo.getTea_createDate() + "','" +
                        teacherInfo.getTea_updateDate() + "'," + teacherInfo.getAd_id() + ")");
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * ��ʦ�޸ĸ�����Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int updateTeaInfo(TeacherInfo teacherInfo) throws Exception {
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        int rows = statement.executeUpdate(
                "UPDATE teacherinfo SET tea_major='" + teacherInfo.getTea_major() + "', tea_updatedate='" +
                        teacherInfo.getTea_updateDate() + "' WHERE tea_id =" + teacherInfo.getTea_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * ����Ա�޸Ľ�ʦ״̬��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int updateTeaStateInfo(TeacherInfo teacherInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "UPDATE teacherinfo SET tea_state='" + teacherInfo.getTea_state() +
                        "',tea_updatedate='" + teacherInfo.getTea_updateDate() + "'WHERE tea_id=" +
                        teacherInfo.getTea_id() + " AND  ad_id = " + teacherInfo.getAd_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * ��ʦ��¼��ѯ
     *
     * @param tea_uName ��ʦ�û���
     * @param tea_pwd   ��ʦ����
     * @return ��ʦ��Ϣ��
     * @throws Exception �׳��쳣
     */
    @Override
    public TeacherInfo queryTeaId(String tea_uName, String tea_pwd) throws Exception {
        TeacherInfo teacherInfo = new TeacherInfo();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM teacherinfo WHERE tea_uname='" + tea_uName + "'AND tea_pwd='" + tea_pwd + "'");
        if (resultSet.next()) {
            teacherInfo.setTea_uName(resultSet.getString("tea_uName"));
            teacherInfo.setTea_pwd(resultSet.getString("tea_pwd"));
            teacherInfo.setTea_id(resultSet.getInt("tea_id"));
            teacherInfo.setTea_state(resultSet.getString("tea_state"));
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return teacherInfo;
    }

    /**
     * ��ʦ��ѯ������Ϣ
     *
     * @param tea_id ��ʦ���
     * @return ��ʦ��Ϣ��
     * @throws Exception �׳��쳣
     */
    @Override
    public TeacherInfo queryTeaInfo(int tea_id) throws Exception {
        TeacherInfo teacherInfo = new TeacherInfo();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from teacherinfo WHERE tea_id=" + tea_id);
        if (resultSet.next()) {
            teacherInfo.setTea_id(resultSet.getInt("tea_id"));
            teacherInfo.setTea_uName(resultSet.getString("tea_uName"));
            teacherInfo.setTea_pwd(resultSet.getString("tea_pwd"));
            teacherInfo.setTea_name(resultSet.getString("tea_name"));
            teacherInfo.setTea_major(resultSet.getString("tea_major"));
            teacherInfo.setTea_createDate(resultSet.getString("tea_createDate"));
            teacherInfo.setTea_updateDate(resultSet.getString("tea_updateDate"));
            teacherInfo.setTea_state(resultSet.getString("tea_state"));
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return teacherInfo;
    }

    /**
     * ����Ա��ѯ��ʦ��Ϣ
     *
     * @return ��ʦ��Ϣ�б���
     * @throws Exception �׳��쳣
     */
    @Override
    public List<TeacherInfo> queryTeaInfoList() throws Exception {
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from teacherinfo ");
        while (resultSet.next()) {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setTea_id(resultSet.getInt("tea_id"));
            teacherInfo.setTea_uName(resultSet.getString("tea_uName"));
            teacherInfo.setTea_pwd(resultSet.getString("tea_pwd"));
            teacherInfo.setTea_name(resultSet.getString("tea_name"));
            teacherInfo.setTea_major(resultSet.getString("tea_major"));
            teacherInfo.setTea_createDate(resultSet.getString("tea_createDate"));
            teacherInfo.setTea_updateDate(resultSet.getString("tea_updateDate"));
            teacherInfo.setTea_state(resultSet.getString("tea_state"));
            teacherInfoList.add(teacherInfo);
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return teacherInfoList;
    }
}
