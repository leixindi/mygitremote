package com.leixindi.dao;

import com.leixindi.bean.StudentResultInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ѧ���ɼ������ݷ��ʲ�ӿ�ʵ�� -- ѧ���ɼ������ݷ���ģ��
 */
public class StudentResultDaoImpl implements StudentResultDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * ���ѧ���ɼ�
     *
     * @param studentResultInfo ѧ���ɼ���
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int addStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "INSERT INTO studentresultinfo(stu_id, sr_result, c_id, tea_id, sr_createdate, " +
                        "sr_updatedate) VALUES (" + studentResultInfo.getStu_id() + "," +
                        studentResultInfo.getSr_result() + "," + studentResultInfo.getC_id() + "," +
                        studentResultInfo.getTea_id() + ",'" + studentResultInfo.getSr_createDate() + "','" +
                        studentResultInfo.getSr_updateDate() + "')");
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * ɾ��ѧ���ɼ�
     *
     * @param sr_id �ɼ����
     * @param tea_id ��ʦ���
     * @return 1 ɾ���ɹ� 0 ɾ��ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int delStudentResultInfo(int sr_id, int tea_id) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "DELETE FROM studentresultinfo where sr_id=" + sr_id + " and tea_id=" + tea_id);
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * �޸�ѧ���ɼ�
     *
     * @param studentResultInfo ѧ����Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int updateStudentResultInfo(StudentResultInfo studentResultInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "UPDATE studentresultinfo SET sr_result=" + studentResultInfo.getSr_result() +
                        ",sr_updatedate= '" + studentResultInfo.getSr_updateDate() + "' WHERE sr_id=" +
                        studentResultInfo.getSr_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }
}
