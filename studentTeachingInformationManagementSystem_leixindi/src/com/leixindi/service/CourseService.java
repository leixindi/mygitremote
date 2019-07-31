package com.leixindi.service;

import com.leixindi.bean.CourseInfo;

import java.util.List;

/**
 * 课程信息的服务类的接口-- 课程的服务模块
 */
public interface CourseService {

    /**
     * 添加课程信息
     *
     * @param courseInfo 课程信息类
     * @return 1 添加成功 0 添加失败
     */
    public int addCourseInfo(CourseInfo courseInfo);

    /**
     * 修改课程信息
     *
     * @param courseInfo 课程信息类
     * @return 1 修改成功 0 修改失败
     */
    public int updateCourseInfo(CourseInfo courseInfo);

    /**
     * 查询课程信息
     *
     * @return 课程信息的列表集合
     */
    public List<CourseInfo> queryCourInfoList();

    /**
     * 课程状态条件下查询课程信息
     *
     * @param c_state 课程状态
     * @return 课程信息的列表集合
     */
    public List<CourseInfo> queryTeaCourInfoList(String c_state);

    /**
     * 修改课程信息状态
     *
     * @param courseInfo 课程信息类
     * @return 1 修改成功 0 修改失败
     */
    public int updateCourStateInfo(CourseInfo courseInfo);
}
