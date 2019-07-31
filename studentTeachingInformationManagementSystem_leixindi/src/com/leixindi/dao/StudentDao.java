package com.leixindi.dao;

import com.leixindi.bean.StudentInfo;

import java.util.List;

/**
 * 学生信息的数据访问层接口 -- 学生信息的数据访问模块
 */
public interface StudentDao {
    /**
     * 增加学生信息
     *
     * @param studentInfo 学生信息类
     * @return 1 添加成功 0 添加失败
     * @throws Exception 抛出异常
     */
    public int addStuInfo(StudentInfo studentInfo) throws Exception;

    /**
     * 学生查询个人信息
     *
     * @param stu_id 学生编号
     * @return 学生信息类
     * @throws Exception 抛出异常
     */
    public StudentInfo queryStuInfo(int stu_id) throws Exception;

    /**
     * 学生修改个人信息
     *
     * @param studentInfo 学生编号
     * @return 1. 修改成功 0. 修改失败
     * @throws Exception 抛出异常
     */
    public int updateStuInfo(StudentInfo studentInfo) throws Exception;

    /**
     * 管理员查询学生所有信息
     *
     * @return 学生信息列表集合
     * @throws Exception 抛出异常
     */
    public List<StudentInfo> queryStuInfoList() throws Exception;

    /**
     * 学生登录查询个人信息
     *
     * @param stu_uName 学生用户名
     * @param stu_pwd 学生密码
     * @return 学生信息类
     * @throws Exception 抛出异常
     */
    public StudentInfo queryTeaId(String stu_uName, String stu_pwd) throws Exception;

    /**
     * 管理员修改学生信息
     *
     * @param studentInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
     */
    public int updateStuStateInfo(StudentInfo studentInfo) throws Exception;
}
