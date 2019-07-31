package com.leixindi.dao;

import com.leixindi.bean.TeacherInfo;

import java.util.List;

/**
 * ��ʦ��Ϣ�����ݷ��ʲ�ӿ� -- ��ʦ��Ϣ�����ݷ���ģ��
 */
public interface TeacherDao {
    /**
     * ��ӽ�ʦ��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    public int addTeaInfo(TeacherInfo teacherInfo) throws Exception;

    /**
     * ��ʦ�޸ĸ�����Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    public int updateTeaInfo(TeacherInfo teacherInfo) throws Exception;

    /**
     * ��ʦ��¼��ѯ
     *
     * @param tea_uName ��ʦ�û���
     * @param tea_pwd ��ʦ����
     * @return ��ʦ��Ϣ��
     * @throws Exception �׳��쳣
     */
    public TeacherInfo queryTeaId(String tea_uName, String tea_pwd) throws Exception;

    /**
     * ����Ա��ѯ��ʦ��Ϣ
     *
     * @return ��ʦ��Ϣ�б���
     * @throws Exception �׳��쳣
     */
    public List<TeacherInfo> queryTeaInfoList() throws Exception;

    /**
     * ��ʦ��ѯ������Ϣ
     *
     * @param tea_id ��ʦ���
     * @return ��ʦ��Ϣ��
     * @throws Exception �׳��쳣
     */
    public TeacherInfo queryTeaInfo(int tea_id) throws Exception;


    /**
     * ����Ա�޸Ľ�ʦ״̬��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    public int updateTeaStateInfo(TeacherInfo teacherInfo) throws Exception;
}
