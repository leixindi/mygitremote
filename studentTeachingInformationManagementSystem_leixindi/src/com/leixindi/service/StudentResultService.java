package com.leixindi.service;

import com.leixindi.bean.StudentResultInfo;

/**
 * ѧ���ɼ���Ϣ�ķ�����Ľӿ�-- ѧ���ɼ��ķ���ģ��
 */
public interface StudentResultService {

    /**
     * ��ʦ���ѧ���ɼ�
     *
     * @param studentResultInfo ѧ���ɼ���Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     */
    public int addStudentResultInfo(StudentResultInfo studentResultInfo);

    /**
     * ��ʦɾ��ѧ���ɼ�
     *
     * @param sr_id �ɼ����
     * @param tea_id ��ʦ���
     * @return 1 ɾ���ɹ� 0 ɾ��ʧ��
     */
    public int delStudentResultInfo(int sr_id, int tea_id);

    /**
     * ��ʦ�޸�ѧ���ɼ�
     *
     * @param studentResultInfo ѧ���ɼ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo);
}
