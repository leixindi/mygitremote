package com.leixindi.service;

import com.leixindi.bean.CourseInfo;
import com.leixindi.dao.CourseDao;
import com.leixindi.dao.CourseDaoImpl;

import java.util.List;

/**
 * �γ���Ϣ��ҵ����ʵ�� -- �γ̵ķ���ģ��
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();


    /**
     * ��ӿγ���Ϣ
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
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
     * �޸Ŀγ���Ϣ
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
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
     * ��ѯ�γ���Ϣ
     *
     * @return �γ���Ϣ���б���
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
     * �γ�״̬�����²�ѯ�γ���Ϣ
     *
     * @param c_state �γ�״̬
     * @return �γ���Ϣ���б���
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
     * �޸Ŀγ���Ϣ
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
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
