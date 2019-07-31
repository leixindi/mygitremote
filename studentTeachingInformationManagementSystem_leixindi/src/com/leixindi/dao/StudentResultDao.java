package com.leixindi.dao;

import com.leixindi.bean.StudentResultInfo;

/**
 * 学生成绩的数据访问层接口 -- 学生成绩的数据访问模块
 */
public interface StudentResultDao {

    /**
     * 添加学生成绩
     *
     * @param studentResultInfo 学生成绩类
     * @return 1 添加成功 0 添加失败
     * @throws Exception 抛出异常
     */
    public int addStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception;

    /**
     * 删除学生成绩
     *
     * @param sr_id 成绩编号
     * @param tea_id 教师编号
     * @return 1 删除成功 0 删除失败
     * @throws Exception 抛出异常
     */
    public int delStudentResultInfo(int sr_id, int tea_id) throws Exception;

    /**
     * 修改学生成绩
     *
     * @param studentResultInfo 学生信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
     */
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception;
}
