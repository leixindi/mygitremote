package com.leixindi.dao;

import com.leixindi.bean.StudentResultInfo;

/**
 * ѧ���ɼ������ݷ��ʲ�ӿ� -- ѧ���ɼ������ݷ���ģ��
 */
public interface StudentResultDao {

    /**
     * ���ѧ���ɼ�
     *
     * @param studentResultInfo ѧ���ɼ���
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    public int addStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception;

    /**
     * ɾ��ѧ���ɼ�
     *
     * @param sr_id �ɼ����
     * @param tea_id ��ʦ���
     * @return 1 ɾ���ɹ� 0 ɾ��ʧ��
     * @throws Exception �׳��쳣
     */
    public int delStudentResultInfo(int sr_id, int tea_id) throws Exception;

    /**
     * �޸�ѧ���ɼ�
     *
     * @param studentResultInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception;
}
