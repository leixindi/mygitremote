package com.leixindi.dao;

import com.leixindi.bean.CourseInfo;

import java.util.List;

/**
 * �γ���Ϣ�����ݷ��ʲ�ӿ�-- �γ̵����ݷ���ģ��
 */
public interface CourseDao {

    /**
     * ��ӿγ�
     *
     * @param courseInfo �γ���
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    public int addCourseInfo(CourseInfo courseInfo) throws Exception;

    /**
     * �޸Ŀγ�ѧ��
     *
     * @param courseInfo �γ���
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    public int updateCourseInfo(CourseInfo courseInfo) throws Exception;

    /**
     * ɾ���γ�
     *
     * @param c_id �γ̱��
     * @return 1 ɾ���ɹ� 0 ɾ��ʧ��
     * @throws Exception �׳��쳣
     */
    public int delCourseInfo(int c_id) throws Exception;

    /**
     * ��ѯ�γ��б�
     *
     * @return �γ��б���
     * @throws Exception �׳��쳣
     */
    public List<CourseInfo> queryCourInfoList() throws Exception;

    /**
     * �γ�״̬�����²�ѯ�γ���Ϣ
     *
     * @param c_state �γ�״̬
     * @return �γ��б���
     * @throws Exception �׳��쳣
     */
    public List<CourseInfo> queryTeaCourInfoList(String c_state) throws Exception;

    /**
     * �޸Ŀγ���Ϣ״̬
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    public int updateCourStateInfo(CourseInfo courseInfo) throws Exception;
}
