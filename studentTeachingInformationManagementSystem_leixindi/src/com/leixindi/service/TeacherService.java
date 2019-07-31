package com.leixindi.service;

import com.leixindi.bean.TeacherInfo;

import java.util.List;

/**
 * 教师信息的服务类的接口-- 教师的服务模块
 */
public interface TeacherService {
    /**
     * 添加教师信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 添加成功 0 添加失败
     */
    public int addTeaInfo(TeacherInfo teacherInfo);

    /**
     * 教师查询个人信息
     *
     * @param tea_id 教师编号
     * @return 教师信息类
     */
    public TeacherInfo queryTeaInfo(int tea_id);

    /**
     * 教师修改个人信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     */
    public int updateTeaInfo(TeacherInfo teacherInfo);

    /**
     * 教师的登录查询
     *
     * @param tea_uName 教师用户名
     * @param tea_pwd   教师密码
     * @return 教师信息类
     */
    public TeacherInfo queryTeaLogin(String tea_uName, String tea_pwd);

    /**
     * 管理员查询教师信息
     *
     * @return 教师信息列表集合
     */
    public List<TeacherInfo> queryTeaInfoList();

    /**
     * 管理员修改教师状态信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     */
    public int updateTeaStateInfo(TeacherInfo teacherInfo);
}
