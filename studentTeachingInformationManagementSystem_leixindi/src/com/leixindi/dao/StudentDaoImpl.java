package com.leixindi.dao;

import com.leixindi.bean.StudentInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ѧ����Ϣ�����ݷ��ʲ�ӿ�ʵ�� -- ѧ����Ϣ�����ݷ���ģ��
 */
public class StudentDaoImpl implements StudentDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    /**
     * ����ѧ����Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int addStuInfo(StudentInfo studentInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "INSERT INTO studentinfo(stu_uname, stu_pwd, stu_name, stu_sex, stu_age, stu_phone," +
                        " stu_major, stu_createdate, stu_updatedate, ad_id) " +
                        "values ('" + studentInfo.getStu_uName() + "','" +
                        studentInfo.getStu_pwd() + "','" + studentInfo.getStu_name() + "','" + studentInfo.getStu_sex()
                        + "'," + studentInfo.getStu_age() + ",'" + studentInfo.getStu_phone() + "','" +
                        studentInfo.getStu_major() + "','" + studentInfo.getStu_createDate() + "','" +
                        studentInfo.getStu_updateDate() + "'," + studentInfo.getAd_id() + ")");
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * ѧ����ѯ������Ϣ
     *
     * @param stu_id ѧ�����
     * @return ѧ����Ϣ��
     * @throws Exception �׳��쳣
     */
    @Override
    public StudentInfo queryStuInfo(int stu_id) throws Exception {
        StudentInfo studentInfo = new StudentInfo();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("Select * FROM studentinfo WHERE stu_id=" + stu_id);
        if (resultSet.next()) {
            studentInfo.setStu_id(resultSet.getInt("stu_id"));
            studentInfo.setStu_uName(resultSet.getString("stu_uname"));
            studentInfo.setStu_pwd(resultSet.getString("stu_pwd"));
            studentInfo.setStu_name(resultSet.getString("stu_name"));
            studentInfo.setStu_sex(resultSet.getString("stu_sex"));
            studentInfo.setStu_age(resultSet.getInt("stu_age"));
            studentInfo.setStu_phone(resultSet.getString("stu_phone"));
            studentInfo.setStu_major(resultSet.getString("stu_major"));
            studentInfo.setAd_id(resultSet.getInt("ad_id"));
            studentInfo.setStu_createDate(resultSet.getString("stu_createDate"));
            studentInfo.setStu_updateDate(resultSet.getString("stu_updateDate"));
            studentInfo.setStu_state(resultSet.getString("stu_state"));
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return studentInfo;
    }

    /**
     * ѧ���޸ĸ�����Ϣ
     *
     * @param studentInfo ѧ�����
     * @return 1. �޸ĳɹ� 0. �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int updateStuInfo(StudentInfo studentInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "UPDATE studentinfo SET stu_phone ='" + studentInfo.getStu_phone() + "',stu_major='" +
                        studentInfo.getStu_major() + "',stu_updatedate = '" + studentInfo.getStu_updateDate()
                        + "' WHERE stu_id= " + studentInfo.getStu_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * ����Ա��ѯѧ��������Ϣ
     *
     * @return ѧ����Ϣ�б���
     * @throws Exception �׳��쳣
     */
    @Override
    public List<StudentInfo> queryStuInfoList() throws Exception {
        List<StudentInfo> studentInfoList = new ArrayList<>();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("Select * FROM studentinfo");
        while (resultSet.next()) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStu_id(resultSet.getInt("stu_id"));
            studentInfo.setStu_uName(resultSet.getString("stu_uName"));
            studentInfo.setStu_pwd(resultSet.getString("stu_pwd"));
            studentInfo.setStu_name(resultSet.getString("stu_name"));
            studentInfo.setStu_sex(resultSet.getString("stu_sex"));
            studentInfo.setStu_age(resultSet.getInt("stu_age"));
            studentInfo.setStu_phone(resultSet.getString("stu_phone"));
            studentInfo.setStu_major(resultSet.getString("stu_major"));
            studentInfo.setAd_id(resultSet.getInt("ad_id"));
            studentInfo.setStu_createDate(resultSet.getString("stu_createDate"));
            studentInfo.setStu_updateDate(resultSet.getString("stu_updateDate"));
            studentInfo.setStu_state(resultSet.getString("stu_state"));
            studentInfoList.add(studentInfo);
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return studentInfoList;
    }

    /**
     * ѧ����¼��ѯ
     *
     * @param stu_uName ѧ���û���
     * @param stu_pwd   ѧ������
     * @return ѧ����Ϣ��
     * @throws Exception �׳��쳣
     */
    @Override
    public StudentInfo queryTeaId(String stu_uName, String stu_pwd) throws Exception {
        StudentInfo studentInfo = new StudentInfo();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM studentinfo WHERE stu_uname='" + stu_uName + "'AND stu_pwd='" + stu_pwd + "'");
        while (resultSet.next()) {
            studentInfo.setStu_uName(resultSet.getString("stu_uName"));
            studentInfo.setStu_pwd(resultSet.getString("stu_pwd"));
            studentInfo.setStu_id(resultSet.getInt("stu_id"));
            studentInfo.setStu_state(resultSet.getString("stu_state"));
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return studentInfo;
    }

    /**
     * ����Ա�޸�ѧ����Ϣ״̬
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int updateStuStateInfo(StudentInfo studentInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "UPDATE studentinfo SET stu_state='" + studentInfo.getStu_state() +
                        "',stu_updatedate='" + studentInfo.getStu_updateDate() + "'WHERE stu_id=" +
                        studentInfo.getStu_id() + " AND  ad_id = " + studentInfo.getAd_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }
}
