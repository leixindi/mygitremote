package com.leixindi.service;

import com.leixindi.bean.ResultCourseInfo;

import java.util.List;

/**
 * ѧ�����γ̡���ʦ���ɼ�����ѯ�ķ�����Ľӿ�-- ����ѯ�ķ���ģ��
 */
public interface ResultCourseService {
    /**
     * ��ʦ��ѯѧ���ɼ�
     *
     * @param tea_id ��ʦ���
     * @return ѧ���ɼ����б���
     */
    public List<ResultCourseInfo> queryStuResultInfoList(int tea_id);

    /**
     * ѧ����ѯ���˳ɼ�
     *
     * @param stu_id ��ʦ���
     * @return ���˳ɼ����б���
     */
    public List<ResultCourseInfo> queryStudentResultInfoList(int stu_id);
}
