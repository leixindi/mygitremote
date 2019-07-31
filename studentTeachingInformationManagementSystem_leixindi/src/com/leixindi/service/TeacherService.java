package com.leixindi.service;

import com.leixindi.bean.TeacherInfo;

import java.util.List;

/**
 * ��ʦ��Ϣ�ķ�����Ľӿ�-- ��ʦ�ķ���ģ��
 */
public interface TeacherService {
    /**
     * ��ӽ�ʦ��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     */
    public int addTeaInfo(TeacherInfo teacherInfo);

    /**
     * ��ʦ��ѯ������Ϣ
     *
     * @param tea_id ��ʦ���
     * @return ��ʦ��Ϣ��
     */
    public TeacherInfo queryTeaInfo(int tea_id);

    /**
     * ��ʦ�޸ĸ�����Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    public int updateTeaInfo(TeacherInfo teacherInfo);

    /**
     * ��ʦ�ĵ�¼��ѯ
     *
     * @param tea_uName ��ʦ�û���
     * @param tea_pwd   ��ʦ����
     * @return ��ʦ��Ϣ��
     */
    public TeacherInfo queryTeaLogin(String tea_uName, String tea_pwd);

    /**
     * ����Ա��ѯ��ʦ��Ϣ
     *
     * @return ��ʦ��Ϣ�б���
     */
    public List<TeacherInfo> queryTeaInfoList();

    /**
     * ����Ա�޸Ľ�ʦ״̬��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    public int updateTeaStateInfo(TeacherInfo teacherInfo);
}
