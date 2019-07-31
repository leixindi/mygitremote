package com.leixindi.service;

import com.leixindi.bean.StudentResultInfo;
import com.leixindi.dao.StudentResultDao;
import com.leixindi.dao.StudentResultDaoImpl;

/**
 * ѧ���ɼ���Ϣ��ҵ����ʵ�� -- ѧ���ɼ��ķ���ģ��
 */
public class StudentResultServiceImpl implements StudentResultService {
    private StudentResultDao studentResultDao = new StudentResultDaoImpl();

    /**
     * ��ʦ���ѧ���ɼ�
     *
     * @param studentResultInfo ѧ���ɼ���Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     */
    @Override
    public int addStudentResultInfo(StudentResultInfo studentResultInfo) {
        int rows = 0;
        try {
            rows = studentResultDao.addStudentResultInfo(studentResultInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * ��ʦɾ��ѧ���ɼ�
     *
     * @param sr_id  �ɼ����
     * @param tea_id ��ʦ���
     * @return 1 ɾ���ɹ� 0 ɾ��ʧ��
     */
    @Override
    public int delStudentResultInfo(int sr_id, int tea_id) {
        int rows = 0;
        try {
            rows = studentResultDao.delStudentResultInfo(sr_id, tea_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * ��ʦ�޸�ѧ���ɼ�
     *
     * @param studentResultInfo ѧ���ɼ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    @Override
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo) {
        int rows = 0;
        try {
            rows = studentResultDao.updateStudentResultInfo(studentResultInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
