package com.leixindi.service;

import com.leixindi.bean.TeacherInfo;
import com.leixindi.dao.TeacherDao;
import com.leixindi.dao.TeacherDaoImpl;

import java.util.List;

/**
 * 教师信息的业务层的实现 -- 教师的服务模块
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();

    /**
     * 添加教师信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 添加成功 0 添加失败
     */
    @Override
    public int addTeaInfo(TeacherInfo teacherInfo) {
        int rows = 0;
        try {
            rows = teacherDao.addTeaInfo(teacherInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 教师查询个人信息
     *
     * @param tea_id 教师编号
     * @return 教师信息类
     */

    @Override
    public TeacherInfo queryTeaInfo(int tea_id) {
        TeacherInfo teacherInfo = null;
        try {
            teacherInfo = teacherDao.queryTeaInfo(tea_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfo;
    }

    /**
     * 教师修改个人信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     */
    @Override
    public int updateTeaInfo(TeacherInfo teacherInfo) {
        int rows = 0;
        try {
            rows = teacherDao.updateTeaInfo(teacherInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 教师的登录查询
     *
     * @param tea_uName 教师用户名
     * @param tea_pwd   教师密码
     * @return 教师信息类
     */
    @Override
    public TeacherInfo queryTeaLogin(String tea_uName, String tea_pwd) {
        TeacherInfo teacherInfo = null;
        try {
            teacherInfo = teacherDao.queryTeaId(tea_uName, tea_pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfo;
    }

    /**
     * 管理员查询教师信息
     *
     * @return 教师信息列表集合
     */
    @Override
    public List<TeacherInfo> queryTeaInfoList() {
        List<TeacherInfo> teacherInfoList = null;
        try {
            teacherInfoList = teacherDao.queryTeaInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfoList;
    }

    /**
     * 管理员修改教师状态信息
     *
     * @param teacherInfo 教师信息类
     * @return 1 修改成功 0 修改失败
     */
    @Override
    public int updateTeaStateInfo(TeacherInfo teacherInfo) {
        int rows = 0;
        try {
            rows = teacherDao.updateTeaStateInfo(teacherInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
