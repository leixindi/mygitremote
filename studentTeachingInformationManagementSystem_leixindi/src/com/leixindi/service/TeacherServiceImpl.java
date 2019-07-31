package com.leixindi.service;

import com.leixindi.bean.TeacherInfo;
import com.leixindi.dao.TeacherDao;
import com.leixindi.dao.TeacherDaoImpl;

import java.util.List;

/**
 * ��ʦ��Ϣ��ҵ����ʵ�� -- ��ʦ�ķ���ģ��
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();

    /**
     * ��ӽ�ʦ��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     */
    @Override
    public int addTeaInfo(TeacherInfo teacherInfo) {
        int rows = 0;
        try {
            rows = teacherDao.addTeaInfo(teacherInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * ��ʦ��ѯ������Ϣ
     *
     * @param tea_id ��ʦ���
     * @return ��ʦ��Ϣ��
     */

    @Override
    public TeacherInfo queryTeaInfo(int tea_id) {
        TeacherInfo teacherInfo = null;
        try {
            teacherInfo = teacherDao.queryTeaInfo(tea_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfo;
    }

    /**
     * ��ʦ�޸ĸ�����Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    @Override
    public int updateTeaInfo(TeacherInfo teacherInfo) {
        int rows = 0;
        try {
            rows = teacherDao.updateTeaInfo(teacherInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * ��ʦ�ĵ�¼��ѯ
     *
     * @param tea_uName ��ʦ�û���
     * @param tea_pwd   ��ʦ����
     * @return ��ʦ��Ϣ��
     */
    @Override
    public TeacherInfo queryTeaLogin(String tea_uName, String tea_pwd) {
        TeacherInfo teacherInfo = null;
        try {
            teacherInfo = teacherDao.queryTeaId(tea_uName, tea_pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfo;
    }

    /**
     * ����Ա��ѯ��ʦ��Ϣ
     *
     * @return ��ʦ��Ϣ�б���
     */
    @Override
    public List<TeacherInfo> queryTeaInfoList() {
        List<TeacherInfo> teacherInfoList = null;
        try {
            teacherInfoList = teacherDao.queryTeaInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherInfoList;
    }

    /**
     * ����Ա�޸Ľ�ʦ״̬��Ϣ
     *
     * @param teacherInfo ��ʦ��Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    @Override
    public int updateTeaStateInfo(TeacherInfo teacherInfo) {
        int rows = 0;
        try {
            rows = teacherDao.updateTeaStateInfo(teacherInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
