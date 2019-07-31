package com.leixindi.dao;

import com.leixindi.bean.TeacherInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 教师信息的数据访问层接口实现 -- 教师信息的数据访问模块
 */
public class TeacherDaoImpl implements TeacherDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * 添加教师信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 添加成功 0 添加失败
     * @throws Exception 抛出异常
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
     * 教师修改个人信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
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
     * 管理员修改教师状态信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
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
     * 教师登录查询
     *
     * @param tea_uName 教师用户名
     * @param tea_pwd   教师密码
     * @return 教师信息类
     * @throws Exception 抛出异常
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
     * 教师查询个人信息
     *
     * @param tea_id 教师编号
     * @return 教师信息类
     * @throws Exception 抛出异常
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
     * 管理员查询教师信息
     *
     * @return 教师信息列表集合
     * @throws Exception 抛出异常
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
