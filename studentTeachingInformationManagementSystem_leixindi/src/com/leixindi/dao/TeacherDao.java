package com.leixindi.dao;

import com.leixindi.bean.TeacherInfo;

import java.util.List;

/**
 * 教师信息的数据访问层接口 -- 教师信息的数据访问模块
 */
public interface TeacherDao {
    /**
     * 添加教师信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 添加成功 0 添加失败
     * @throws Exception 抛出异常
     */
    public int addTeaInfo(TeacherInfo teacherInfo) throws Exception;

    /**
     * 教师修改个人信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
     */
    public int updateTeaInfo(TeacherInfo teacherInfo) throws Exception;

    /**
     * 教师登录查询
     *
     * @param tea_uName 教师用户名
     * @param tea_pwd 教师密码
     * @return 教师信息类
     * @throws Exception 抛出异常
     */
    public TeacherInfo queryTeaId(String tea_uName, String tea_pwd) throws Exception;

    /**
     * 管理员查询教师信息
     *
     * @return 教师信息列表集合
     * @throws Exception 抛出异常
     */
    public List<TeacherInfo> queryTeaInfoList() throws Exception;

    /**
     * 教师查询个人信息
     *
     * @param tea_id 教师编号
     * @return 教师信息类
     * @throws Exception 抛出异常
     */
    public TeacherInfo queryTeaInfo(int tea_id) throws Exception;


    /**
     * 管理员修改教师状态信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
     */
    public int updateTeaStateInfo(TeacherInfo teacherInfo) throws Exception;
}
