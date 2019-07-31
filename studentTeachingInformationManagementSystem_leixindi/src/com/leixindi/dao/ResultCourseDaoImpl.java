package com.leixindi.dao;

import com.leixindi.bean.ResultCourseInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程、学生、教师、成绩多表查询的数据访问层接口实现-- 课程、学生、教师、成绩多表查询的数据访问模块
 */
public class ResultCourseDaoImpl implements ResultCourseDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * 教师查询成绩
     *
     * @param tea_id 教师编号
     * @return 多表查询的列表集合
     * @throws Exception 抛出异常
     */
    @Override
    public List<ResultCourseInfo> queryStuResultInfoList(int tea_id) throws Exception {
        List<ResultCourseInfo> resultCourseInfoList = new ArrayList<>();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(
                "Select * FROM studentresultinfo,courseinfo,teacherinfo,studentinfo WHERE" +
                        " studentresultinfo.tea_id=" + tea_id + " AND studentresultinfo.tea_id=teacherinfo.tea_id " +
                        " AND studentresultinfo.c_id=courseinfo.c_id AND studentresultinfo.stu_id=studentinfo.stu_id");
        while (resultSet.next()) {
            ResultCourseInfo resultCourseInfo = new ResultCourseInfo();
            resultCourseInfo.setSr_id(resultSet.getInt("sr_id"));
            resultCourseInfo.setStu_name(resultSet.getString("stu_name"));
            resultCourseInfo.setC_name(resultSet.getString("c_name"));
            resultCourseInfo.setSr_result(resultSet.getInt("sr_result"));
            resultCourseInfo.setSr_createDate(resultSet.getString("sr_createDate"));
            resultCourseInfo.setSr_updateDate(resultSet.getString("sr_updateDate"));
            resultCourseInfo.setTea_name(resultSet.getString("tea_name"));
            resultCourseInfoList.add(resultCourseInfo);
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return resultCourseInfoList;
    }

    /**
     * 学生查询成绩
     *
     * @param stu_id 教师编号
     * @return 多表查询的列表集合
     * @throws Exception 抛出异常
     */
    @Override
    public List<ResultCourseInfo> queryStudentResultInfoList(int stu_id) throws Exception {
        List<ResultCourseInfo> resultCourseInfoList = new ArrayList<>();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(
                "Select * FROM studentresultinfo,courseinfo,teacherinfo,studentinfo WHERE" +
                        " studentresultinfo.stu_id=" + stu_id + " AND studentresultinfo.tea_id=teacherinfo.tea_id " +
                        " AND studentresultinfo.c_id=courseinfo.c_id AND studentresultinfo.stu_id=studentinfo.stu_id");
        while (resultSet.next()) {
            ResultCourseInfo resultCourseInfo = new ResultCourseInfo();
            resultCourseInfo.setSr_id(resultSet.getInt("sr_id"));
            resultCourseInfo.setStu_name(resultSet.getString("stu_name"));
            resultCourseInfo.setC_name(resultSet.getString("c_name"));
            resultCourseInfo.setSr_result(resultSet.getInt("sr_result"));
            resultCourseInfo.setSr_createDate(resultSet.getString("sr_createDate"));
            resultCourseInfo.setSr_updateDate(resultSet.getString("sr_updateDate"));
            resultCourseInfo.setTea_name(resultSet.getString("tea_name"));
            resultCourseInfoList.add(resultCourseInfo);
        }
        dbUtil.closeDBResources(connection, statement, resultSet);
        return resultCourseInfoList;
    }
}
