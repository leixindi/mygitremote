package com.leixindi.service;

import com.leixindi.bean.StudentResultInfo;
import com.leixindi.dao.StudentResultDao;
import com.leixindi.dao.StudentResultDaoImpl;

/**
 * 学生成绩信息的业务层的实现 -- 学生成绩的服务模块
 */
public class StudentResultServiceImpl implements StudentResultService {
    private StudentResultDao studentResultDao = new StudentResultDaoImpl();

    /**
     * 教师添加学生成绩
     *
     * @param studentResultInfo 学生成绩信息类
     * @return 1 添加成功 0 添加失败
     */
    @Override
    public int addStudentResultInfo(StudentResultInfo studentResultInfo) {
        int rows = 0;
        try {
            rows = studentResultDao.addStudentResultInfo(studentResultInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 教师删除学生成绩
     *
     * @param sr_id  成绩编号
     * @param tea_id 教师编号
     * @return 1 删除成功 0 删除失败
     */
    @Override
    public int delStudentResultInfo(int sr_id, int tea_id) {
        int rows = 0;
        try {
            rows = studentResultDao.delStudentResultInfo(sr_id, tea_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 教师修改学生成绩
     *
     * @param studentResultInfo 学生成绩信息类
     * @return 1 修改成功 0 修改失败
     */
    @Override
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo) {
        int rows = 0;
        try {
            rows = studentResultDao.updateStudentResultInfo(studentResultInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
