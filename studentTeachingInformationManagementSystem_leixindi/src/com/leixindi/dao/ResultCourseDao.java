package com.leixindi.dao;

import com.leixindi.bean.ResultCourseInfo;

import java.util.List;


/**
 * 课程、学生、教师、成绩多表查询的数据访问层接口-- 课程、学生、教师、成绩多表查询的数据访问模块
 */
public interface ResultCourseDao {
    /**
     * 教师查询成绩
     *
     * @param tea_id 教师编号
     * @return 多表查询的列表集合
     * @throws Exception 抛出异常
     */
    public List<ResultCourseInfo> queryStuResultInfoList(int tea_id) throws Exception;

    /**
     * 学生查询成绩
     *
     * @param stu_id 教师编号
     * @return 多表查询的列表集合
     * @throws Exception 抛出异常
     */
    public List<ResultCourseInfo> queryStudentResultInfoList(int stu_id) throws Exception;
}
