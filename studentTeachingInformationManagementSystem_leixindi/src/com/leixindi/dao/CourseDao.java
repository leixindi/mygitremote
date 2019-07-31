package com.leixindi.dao;

import com.leixindi.bean.CourseInfo;

import java.util.List;

/**
 * 课程信息的数据访问层接口-- 课程的数据访问模块
 */
public interface CourseDao {

    /**
     * 添加课程
     *
     * @param courseInfo 课程类
     * @return 1 添加成功 0 添加失败
     * @throws Exception 抛出异常
     */
    public int addCourseInfo(CourseInfo courseInfo) throws Exception;

    /**
     * 修改课程学分
     *
     * @param courseInfo 课程类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
     */
    public int updateCourseInfo(CourseInfo courseInfo) throws Exception;

    /**
     * 删除课程
     *
     * @param c_id 课程编号
     * @return 1 删除成功 0 删除失败
     * @throws Exception 抛出异常
     */
    public int delCourseInfo(int c_id) throws Exception;

    /**
     * 查询课程列表
     *
     * @return 课程列表集合
     * @throws Exception 抛出异常
     */
    public List<CourseInfo> queryCourInfoList() throws Exception;

    /**
     * 课程状态条件下查询课程信息
     *
     * @param c_state 课程状态
     * @return 课程列表集合
     * @throws Exception 抛出异常
     */
    public List<CourseInfo> queryTeaCourInfoList(String c_state) throws Exception;

    /**
     * 修改课程信息状态
     *
     * @param courseInfo 课程信息类
     * @return 1 修改成功 0 修改失败
     * @throws Exception 抛出异常
     */
    public int updateCourStateInfo(CourseInfo courseInfo) throws Exception;
}
