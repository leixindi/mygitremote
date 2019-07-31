package com.leixindi.dao;

import com.leixindi.bean.ResultCourseInfo;

import java.util.List;


/**
 * �γ̡�ѧ������ʦ���ɼ�����ѯ�����ݷ��ʲ�ӿ�-- �γ̡�ѧ������ʦ���ɼ�����ѯ�����ݷ���ģ��
 */
public interface ResultCourseDao {
    /**
     * ��ʦ��ѯ�ɼ�
     *
     * @param tea_id ��ʦ���
     * @return ����ѯ���б���
     * @throws Exception �׳��쳣
     */
    public List<ResultCourseInfo> queryStuResultInfoList(int tea_id) throws Exception;

    /**
     * ѧ����ѯ�ɼ�
     *
     * @param stu_id ��ʦ���
     * @return ����ѯ���б���
     * @throws Exception �׳��쳣
     */
    public List<ResultCourseInfo> queryStudentResultInfoList(int stu_id) throws Exception;
}
