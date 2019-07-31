package com.leixindi.service;

import com.leixindi.bean.StudentInfo;

import java.util.List;

/**
 * 学生信息的服务类的接口-- 学生的服务模块
 */
public interface StudentService {
    /**
     * 管理员添加学生信息
     *
     * @param studentInfo 学生信息类
     * @return 1 添加成功 0 添加失败
     */
    public int addStuInfo(StudentInfo studentInfo);

    /**
     * 学生查询个人信息
     *
     * @param stu_id 学生编号
     * @return 学生信息类
     */
    public StudentInfo queryStuInfo(int stu_id);

    /**
     * 学生修改个人信息
     *
     * @param studentInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     */
    public int updateStuInfo(StudentInfo studentInfo);

    /**
     * 管理员查询学生信息
     *
     * @return 学生信息的列表集合
     */
    public List<StudentInfo> queryStuInfoList();

    /**
     * 学生登录的查询
     *
     * @param stu_uName 学生用户名
     * @param stu_pwd 学生密码
     * @return 学生信息类
     */
    public StudentInfo queryStuLogin(String stu_uName, String stu_pwd);

    /**
     * 管理员修改学生状态信息
     *
     * @param studentInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     */
    public int updateStuStateInfo(StudentInfo studentInfo);
}
