package com.leixindi.service;

import com.leixindi.bean.ResultCourseInfo;
import com.leixindi.dao.ResultCourseDao;
import com.leixindi.dao.ResultCourseDaoImpl;

import java.util.List;

/**
 * ѧ�����γ̡���ʦ���ɼ�����ѯ��ҵ����ʵ��-- ����ѯ�ķ���ģ��
 */
public class ResultCourseServiceImpl implements ResultCourseService {
    private ResultCourseDao resultCourseDao = new ResultCourseDaoImpl();

    /**
     * ��ʦ��ѯѧ���ɼ�
     *
     * @param tea_id ��ʦ���
     * @return ѧ���ɼ����б���
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
     * ѧ����ѯ���˳ɼ�
     *
     * @param stu_id ��ʦ���
     * @return ���˳ɼ����б���
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
