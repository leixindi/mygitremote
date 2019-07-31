package com.leixindi.dao;

import com.leixindi.bean.CourseInfo;
import com.leixindi.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * �γ̹�������ݷ��ʲ�ӿ�ʵ�� -- �γ̹�������ݷ���ģ��
 */
public class CourseDaoImpl implements CourseDao {
    private DBUtil dbUtil = new DBUtil();
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * ��ӿγ�
     *
     * @param courseInfo �γ���
     * @return 1 ��ӳɹ� 0 ���ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int addCourseInfo(CourseInfo courseInfo) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate(
                "INSERT INTO courseinfo(c_name, c_credit, ad_id, c_createdate, c_updatedate) " +
                        "values ('" + courseInfo.getC_name() + "'," + courseInfo.getC_credit() +
                        "," + courseInfo.getAd_id() + ",'" + courseInfo.getC_createDate() + "','"
                        + courseInfo.getC_updateDate() + "')");
        dbUtil.closeDBResources(connection, statement, null);
        return rows;
    }

    /**
     * �޸Ŀγ�ѧ��
     *
     * @param courseInfo �γ���
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int updateCourseInfo(CourseInfo courseInfo) throws Exception {
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate("UPDATE courseinfo SET c_credit=" + courseInfo.getC_credit()
                + ", c_updatedate = '" + courseInfo.getC_updateDate()
                + "' where c_id =" + courseInfo.getC_id() + " AND  ad_id =" + courseInfo.getAd_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }

    /**
     * ɾ���γ�
     *
     * @param c_id �γ̱��
     * @return 1 ɾ���ɹ� 0 ɾ��ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int delCourseInfo(int c_id) throws Exception {
        int rows = 0;
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate("DELETE FROM courseinfo where c_id=" + c_id);
        return rows;
    }

    /**
     * ��ѯ�γ��б�
     *
     * @return �γ��б�
     * @throws Exception �׳��쳣
     */
    @Override
    public List<CourseInfo> queryCourInfoList() throws Exception {
        List<CourseInfo> courseInfoList = new ArrayList<>();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM courseinfo ");
        while (resultSet.next()) {
            CourseInfo courseInfo = new CourseInfo();
            courseInfo.setC_id(resultSet.getInt("c_id"));
            courseInfo.setC_name(resultSet.getString("c_name"));
            courseInfo.setC_credit(resultSet.getInt("c_credit"));
            courseInfo.setC_createDate(resultSet.getString("c_createDate"));
            courseInfo.setC_updateDate(resultSet.getString("c_updateDate"));
            courseInfo.setC_state(resultSet.getString("c_state"));
            courseInfoList.add(courseInfo);
        }
        return courseInfoList;
    }

    /**
     * �γ�״̬�����²�ѯ�γ���Ϣ
     *
     * @param c_state �γ�״̬
     * @return �γ��б�
     * @throws Exception �׳��쳣
     */
    @Override
    public List<CourseInfo> queryTeaCourInfoList(String c_state) throws Exception {
        List<CourseInfo> courseInfoList = new ArrayList<>();
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM courseinfo where c_state='"+c_state+"'");
        while (resultSet.next()) {
            CourseInfo courseInfo = new CourseInfo();
            courseInfo.setC_id(resultSet.getInt("c_id"));
            courseInfo.setC_name(resultSet.getString("c_name"));
            courseInfo.setC_credit(resultSet.getInt("c_credit"));
            courseInfo.setC_createDate(resultSet.getString("c_createDate"));
            courseInfo.setC_updateDate(resultSet.getString("c_updateDate"));
            courseInfoList.add(courseInfo);
        }
        return courseInfoList;
    }

    /**
     * �޸Ŀγ���Ϣ״̬
     *
     * @param courseInfo �γ���Ϣ��
     * @return 1 �޸ĳɹ� 0 �޸�ʧ��
     * @throws Exception �׳��쳣
     */
    @Override
    public int updateCourStateInfo(CourseInfo courseInfo) throws Exception {
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        connection = dbUtil.getConnection();
        statement = connection.createStatement();
        rows = statement.executeUpdate("UPDATE courseinfo SET c_state='" + courseInfo.getC_state()
                + "', c_updatedate = '" + courseInfo.getC_updateDate()
                + "' where c_id =" + courseInfo.getC_id() + " AND  ad_id =" + courseInfo.getAd_id());
        dbUtil.closeDBResources(connection, statement, resultSet);
        return rows;
    }
}
