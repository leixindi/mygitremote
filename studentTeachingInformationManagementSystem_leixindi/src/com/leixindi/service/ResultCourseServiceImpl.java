package com.leixindi.service;

import com.leixindi.bean.ResultCourseInfo;
import com.leixindi.dao.ResultCourseDao;
import com.leixindi.dao.ResultCourseDaoImpl;

import java.util.List;

/**
 * 学生、课程、教师、成绩多表查询的业务层的实现-- 多表查询的服务模块
 */
public class ResultCourseServiceImpl implements ResultCourseService {
    private ResultCourseDao resultCourseDao = new ResultCourseDaoImpl();

    /**
     * 教师查询学生成绩
     *
     * @param tea_id 教师编号
     * @return 学生成绩的列表集合
     */
    @Override
    public List<ResultCourseInfo> queryStuResultInfoList(int tea_id) {
        List<ResultCourseInfo> resultCourseInfoList = null;
        try {
            resultCourseInfoList = resultCourseDao.queryStuResultInfoList(tea_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultCourseInfoList;
    }

    /**
     * 学生查询个人成绩
     *
     * @param stu_id 教师编号
     * @return 个人成绩的列表集合
     */
    @Override
    public List<ResultCourseInfo> queryStudentResultInfoList(int stu_id) {
        List<ResultCourseInfo> resultCourseInfoList = null;
        try {
            resultCourseInfoList = resultCourseDao.queryStudentResultInfoList(stu_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultCourseInfoList;
    }
}
