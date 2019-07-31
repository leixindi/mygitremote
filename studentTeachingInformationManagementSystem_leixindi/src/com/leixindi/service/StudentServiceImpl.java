package com.leixindi.service;

import com.leixindi.bean.StudentInfo;
import com.leixindi.dao.StudentDao;
import com.leixindi.dao.StudentDaoImpl;

import java.util.List;

/**
 * ѧ����Ϣ��ҵ����ʵ�� -- ѧ���ķ���ģ��
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    /**
     * ����Ա���ѧ����Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 ��ӳɹ� 0 ���ʧ��
     */
    @Override
    public int addStuInfo(StudentInfo studentInfo) {
        int rows = 0;
        try {
            rows = studentDao.addStuInfo(studentInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * ѧ����ѯ������Ϣ
     *
     * @param stu_id ѧ�����
     * @return ѧ����Ϣ��
     */
    @Override
    public StudentInfo queryStuInfo(int stu_id) {
        StudentInfo studentInfo = null;
        try {
            studentInfo = studentDao.queryStuInfo(stu_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfo;
    }

    /**
     * ѧ���޸ĸ�����Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    @Override
    public int updateStuInfo(StudentInfo studentInfo) {
        int rows = 0;
        try {
            rows = studentDao.updateStuInfo(studentInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    /**
     * ����Ա��ѯѧ����Ϣ
     *
     * @return ѧ����Ϣ���б���
     */
    @Override
    public List<StudentInfo> queryStuInfoList() {
        List<StudentInfo> studentInfoList = null;
        try {
            studentInfoList = studentDao.queryStuInfoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfoList;
    }

    /**
     * ѧ����¼�Ĳ�ѯ
     *
     * @param stu_uName ѧ���û���
     * @param stu_pwd   ѧ������
     * @return ѧ����Ϣ��
     */
    @Override
    public StudentInfo queryStuLogin(String stu_uName, String stu_pwd) {
        StudentInfo studentInfo = null;
        try {
            studentInfo = studentDao.queryTeaId(stu_uName, stu_pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfo;
    }

    /**
     * ����Ա�޸�ѧ��״̬��Ϣ
     *
     * @param studentInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     */
    @Override
    public int updateStuStateInfo(StudentInfo studentInfo) {
        int rows = 0;
        try {
            rows = studentDao.updateStuStateInfo(studentInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }
}
