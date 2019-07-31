package com.leixindi.service;

import com.leixindi.bean.CourseInfo;
import com.leixindi.dao.CourseDao;
import com.leixindi.dao.CourseDaoImpl;

import java.util.List;

/**
 * 课程信息的业务层的实现 -- 课程的服务模块
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();


    /**
     * 添加课程信息
     *
     * @param courseInfo 课程信息类
     * @return 1 添加成功 0 添加失败
     */
    @Override
    public int addCourseInfo(CourseInfo courseInfo) {
        int rows = 0;
        try {
            rows = courseDao.addCourseInfo(courseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 修改课程信息
     *
     * @param courseInfo 课程信息类
     * @return 1 修改成功 0 修改失败
     */
    @Override
    public int updateCourseInfo(CourseInfo courseInfo) {
        int rows = 0;
        try {
            rows = courseDao.updateCourseInfo(courseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * 查询课程信息
     *
     * @return 课程信息的列表集合
     */
    @Override
    public List<CourseInfo> queryCourInfoList() {
        List<CourseInfo> courseInfoList = null;
        try {
            courseInfoList = courseDao.queryCourInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseInfoList;
    }


    /**
     * 课程状态条件下查询课程信息
     *
     * @param c_state 课程状态
     * @return 课程信息的列表集合
     */
    @Override
    public List<CourseInfo> queryTeaCourInfoList(String c_state) {
        List<CourseInfo> courseInfoList = null;
        try {
            courseInfoList = courseDao.queryTeaCourInfoList(c_state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseInfoList;
    }

    /**
     * 修改课程信息
     *
     * @param courseInfo 课程信息类
     * @return 1 修改成功 0 修改失败
     */
    @Override
    public int updateCourStateInfo(CourseInfo courseInfo) {
        int rows = 0;
        try {
            rows = courseDao.updateCourStateInfo(courseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
