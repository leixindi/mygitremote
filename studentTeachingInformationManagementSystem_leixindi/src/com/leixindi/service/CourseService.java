package com.leixindi.service;

import com.leixindi.bean.CourseInfo;

import java.util.List;

/**
 * �γ���Ϣ�ķ�����Ľӿ�-- �γ̵ķ���ģ��
 */
public interface CourseService {

    /**
     * ��ӿγ���Ϣ
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     */
    public int addCourseInfo(CourseInfo courseInfo);

    /**
     * �޸Ŀγ���Ϣ
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    public int updateCourseInfo(CourseInfo courseInfo);

    /**
     * ��ѯ�γ���Ϣ
     *
     * @return �γ���Ϣ���б���
     */
    public List<CourseInfo> queryCourInfoList();

    /**
     * �γ�״̬�����²�ѯ�γ���Ϣ
     *
     * @param c_state �γ�״̬
     * @return �γ���Ϣ���б���
     */
    public List<CourseInfo> queryTeaCourInfoList(String c_state);

    /**
     * �޸Ŀγ���Ϣ״̬
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    public int updateCourStateInfo(CourseInfo courseInfo);
}
