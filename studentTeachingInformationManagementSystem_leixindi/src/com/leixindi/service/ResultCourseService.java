package com.leixindi.service;

import com.leixindi.bean.ResultCourseInfo;

import java.util.List;

/**
 * 学生、课程、教师、成绩多表查询的服务类的接口-- 多表查询的服务模块
 */
public interface ResultCourseService {
    /**
     * 教师查询学生成绩
     *
     * @param tea_id 教师编号
     * @return 学生成绩的列表集合
     */
    public List<ResultCourseInfo> queryStuResultInfoList(int tea_id);

    /**
     * 学生查询个人成绩
     *
     * @param stu_id 教师编号
     * @return 个人成绩的列表集合
     */
    public List<ResultCourseInfo> queryStudentResultInfoList(int stu_id);
}
