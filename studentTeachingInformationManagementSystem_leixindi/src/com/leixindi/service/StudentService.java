package com.leixindi.service;

import com.leixindi.bean.StudentInfo;

import java.util.List;

/**
 * ѧ����Ϣ�ķ�����Ľӿ�-- ѧ���ķ���ģ��
 */
public interface StudentService {
    /**
     * ����Ա���ѧ����Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     */
    public int addStuInfo(StudentInfo studentInfo);

    /**
     * ѧ����ѯ������Ϣ
     *
     * @param stu_id ѧ�����
     * @return ѧ����Ϣ��
     */
    public StudentInfo queryStuInfo(int stu_id);

    /**
     * ѧ���޸ĸ�����Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    public int updateStuInfo(StudentInfo studentInfo);

    /**
     * ����Ա��ѯѧ����Ϣ
     *
     * @return ѧ����Ϣ���б���
     */
    public List<StudentInfo> queryStuInfoList();

    /**
     * ѧ����¼�Ĳ�ѯ
     *
     * @param stu_uName ѧ���û���
     * @param stu_pwd ѧ������
     * @return ѧ����Ϣ��
     */
    public StudentInfo queryStuLogin(String stu_uName, String stu_pwd);

    /**
     * ����Ա�޸�ѧ��״̬��Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    public int updateStuStateInfo(StudentInfo studentInfo);
}
