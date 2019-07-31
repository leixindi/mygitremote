package com.leixindi.service;

import com.leixindi.bean.StudentInfo;
import com.leixindi.dao.StudentDao;
import com.leixindi.dao.StudentDaoImpl;

import java.util.List;

/**
 * 学生信息的业务层的实现 -- 学生的服务模块
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    /**
     * 管理员添加学生信息
     *
     * @param studentInfo 学生信息类
     * @return 1 添加成功 0 添加失败
     */
    @Override
    public int addStuInfo(StudentInfo studentInfo) {
        int rows = 0;
        try {
            rows = studentDao.addStuInfo(studentInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 学生查询个人信息
     *
     * @param stu_id 学生编号
     * @return 学生信息类
     */
    @Override
    public StudentInfo queryStuInfo(int stu_id) {
        StudentInfo studentInfo = null;
        try {
            studentInfo = studentDao.queryStuInfo(stu_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfo;
    }

    /**
     * 学生修改个人信息
     *
     * @param studentInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     */
    @Override
    public int updateStuInfo(StudentInfo studentInfo) {
        int rows = 0;
        try {
            rows = studentDao.updateStuInfo(studentInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 管理员查询学生信息
     *
     * @return 学生信息的列表集合
     */
    @Override
    public List<StudentInfo> queryStuInfoList() {
        List<StudentInfo> studentInfoList = null;
        try {
            studentInfoList = studentDao.queryStuInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfoList;
    }

    /**
     * 学生登录的查询
     *
     * @param stu_uName 学生用户名
     * @param stu_pwd   学生密码
     * @return 学生信息类
     */
    @Override
    public StudentInfo queryStuLogin(String stu_uName, String stu_pwd) {
        StudentInfo studentInfo = null;
        try {
            studentInfo = studentDao.queryTeaId(stu_uName, stu_pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfo;
    }

    /**
     * 管理员修改学生状态信息
     *
     * @param studentInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     */
    @Override
    public int updateStuStateInfo(StudentInfo studentInfo) {
        int rows = 0;
        try {
            rows = studentDao.updateStuStateInfo(studentInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
