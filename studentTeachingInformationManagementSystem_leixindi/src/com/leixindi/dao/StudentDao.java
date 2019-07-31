package com.leixindi.dao;

import com.leixindi.bean.StudentInfo;

import java.util.List;

/**
 * ѧ����Ϣ�����ݷ��ʲ�ӿ� -- ѧ����Ϣ�����ݷ���ģ��
 */
public interface StudentDao {
    /**
     * ����ѧ����Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    public int addStuInfo(StudentInfo studentInfo) throws Exception;

    /**
     * ѧ����ѯ������Ϣ
     *
     * @param stu_id ѧ�����
     * @return ѧ����Ϣ��
     * @throws Exception �׳��쳣
     */
    public StudentInfo queryStuInfo(int stu_id) throws Exception;

    /**
     * ѧ���޸ĸ�����Ϣ
     *
     * @param studentInfo ѧ�����
     * @return 1. �޸ĳɹ� 0. �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    public int updateStuInfo(StudentInfo studentInfo) throws Exception;

    /**
     * ����Ա��ѯѧ��������Ϣ
     *
     * @return ѧ����Ϣ�б���
     * @throws Exception �׳��쳣
     */
    public List<StudentInfo> queryStuInfoList() throws Exception;

    /**
     * ѧ����¼��ѯ������Ϣ
     *
     * @param stu_uName ѧ���û���
     * @param stu_pwd ѧ������
     * @return ѧ����Ϣ��
     * @throws Exception �׳��쳣
     */
    public StudentInfo queryTeaId(String stu_uName, String stu_pwd) throws Exception;

    /**
     * ����Ա�޸�ѧ����Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    public int updateStuStateInfo(StudentInfo studentInfo) throws Exception;
}
