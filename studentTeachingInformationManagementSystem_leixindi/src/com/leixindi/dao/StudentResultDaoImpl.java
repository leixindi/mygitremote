package com.leixindi.dao;

import com.leixindi.bean.StudentResultInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 学生成绩的数据访问层接口实现 -- 学生成绩的数据访问模块
 */
public class StudentResultDaoImpl implements StudentResultDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * 添加学生成绩
     *
     * @param studentResultInfo 学生成绩类
     * @return 1 添加成功 0 添加失败
     * @throws Exception 抛出异常
     */
    @Override
    public int addStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "INSERT INTO studentresultinfo(stu_id, sr_result, c_id, tea_id, sr_createdate, " +
                        "sr_updatedate) VALUES (" + studentResultInfo.getStu_id() + "," +
                        studentResultInfo.getSr_result() + "," + studentResultInfo.getC_id() + "," +
                        studentResultInfo.getTea_id() + ",'" + studentResultInfo.getSr_createDate() + "','" +
                        studentResultInfo.getSr_updateDate() + "')");
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * 删除学生成绩
     *
     * @param sr_id 成绩编号
     * @param tea_id 教师编号
     * @return 1 删除成功 0 删除失败
     * @throws Exception 抛出异常
     */
    @Override
    public int delStudentResultInfo(int sr_id, int tea_id) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "DELETE FROM studentresultinfo where sr_id=" + sr_id + " and tea_id=" + tea_id);
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * 修改学生成绩
     *
     * @param studentResultInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
     */
    @Override
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "UPDATE studentresultinfo SET sr_result=" + studentResultInfo.getSr_result() +
                        ",sr_updatedate= '" + studentResultInfo.getSr_updateDate() + "' WHERE sr_id=" +
                        studentResultInfo.getSr_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }
}
