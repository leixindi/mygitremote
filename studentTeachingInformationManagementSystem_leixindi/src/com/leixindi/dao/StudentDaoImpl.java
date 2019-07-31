package com.leixindi.dao;

import com.leixindi.bean.StudentInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生信息的数据访问层接口实现 -- 学生信息的数据访问模块
 */
public class StudentDaoImpl implements StudentDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    /**
     * 增加学生信息
     *
     * @param studentInfo 学生信息类
     * @return 1 添加成功 0 添加失败
     * @throws Exception 抛出异常
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
     * 学生查询个人信息
     *
     * @param stu_id 学生编号
     * @return 学生信息类
     * @throws Exception 抛出异常
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
     * 学生修改个人信息
     *
     * @param studentInfo 学生编号
     * @return 1. 修改成功 0. 修改失败
     * @throws Exception 抛出异常
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
     * 管理员查询学生所有信息
     *
     * @return 学生信息列表集合
     * @throws Exception 抛出异常
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
     * 学生登录查询
     *
     * @param stu_uName 学生用户名
     * @param stu_pwd   学生密码
     * @return 学生信息类
     * @throws Exception 抛出异常
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
     * 管理员修改学生信息状态
     *
     * @param studentInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
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
