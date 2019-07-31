package com.leixindi.service;

import com.leixindi.bean.StudentResultInfo;

/**
 * 学生成绩信息的服务类的接口-- 学生成绩的服务模块
 */
public interface StudentResultService {

    /**
     * 教师添加学生成绩
     *
     * @param studentResultInfo 学生成绩信息类
     * @return 1 添加成功 0 添加失败
     */
    public int addStudentResultInfo(StudentResultInfo studentResultInfo);

    /**
     * 教师删除学生成绩
     *
     * @param sr_id 成绩编号
     * @param tea_id 教师编号
     * @return 1 删除成功 0 删除失败
     */
    public int delStudentResultInfo(int sr_id, int tea_id);

    /**
     * 教师修改学生成绩
     *
     * @param studentResultInfo 学生成绩信息类
     * @return 1 修改成功 0 修改失败
     */
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo);
}
