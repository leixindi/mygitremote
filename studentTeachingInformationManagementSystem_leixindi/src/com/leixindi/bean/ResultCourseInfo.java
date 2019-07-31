package com.leixindi.bean;

/**
 * 用于学生表、教师表、成绩表和课程表的联合查询
 */
public class ResultCourseInfo {
    /**
     * 成绩的编号
     */
    private int sr_id;
    /**
     * 学生姓名
     */
    private String stu_name;
    /**
     * 课程成绩
     */
    private int sr_result;
    /**
     * 课程名称
     */
    private String c_name;
    /**
     * 教师姓名
     */
    private String tea_name;
    /**
     * 成绩的创建时间
     */
    private String sr_createDate;
    /**
     * 成绩的更新时间
     */
    private String sr_updateDate;

    /**
     * 获取学生姓名
     *
     * @return 学生姓名
     */
    public String getStu_name() {
        return stu_name;
    }

    /**
     * 设置学生姓名
     *
     * @param stu_name 学生姓名
     */
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    /**
     * 获取学生课程成绩
     *
     * @return 获取学生课程成绩
     */
    public int getSr_result() {
        return sr_result;
    }

    /**
     * 设置学生课程成绩
     *
     * @param sr_result 学生课程成绩
     */
    public void setSr_result(int sr_result) {
        this.sr_result = sr_result;
    }

    /**
     * 获取成绩编号
     *
     * @return 成绩编号
     */
    public int getSr_id() {
        return sr_id;
    }

    /**
     * 设置成绩编号
     *
     * @param sr_id 成绩编号
     */
    public void setSr_id(int sr_id) {
        this.sr_id = sr_id;
    }

    /**
     * 获取课程编号
     *
     * @return 课程编号
     */
    public String getC_name() {
        return c_name;
    }

    /**
     * 设置课程编号
     *
     * @param c_name 课程编号
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    /**
     * 获取教师编号
     *
     * @return 课程编号
     */
    public String getTea_name() {
        return tea_name;
    }

    /**
     * 设置课程编号
     *
     * @param tea_name 课程编号
     */
    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    /**
     * 获取成绩创建时间
     *
     * @return 成绩创建时间
     */
    public String getSr_createDate() {
        return sr_createDate;
    }

    /**
     * 设置成绩创建时间
     *
     * @param sr_createDate 成绩创建时间
     */
    public void setSr_createDate(String sr_createDate) {
        this.sr_createDate = sr_createDate;
    }

    /**
     * 获取成绩更新时间
     *
     * @return 成绩更新时间
     */
    public String getSr_updateDate() {
        return sr_updateDate;
    }

    /**
     * 设置成绩更新时间
     *
     * @param sr_updateDate 成绩更新时间
     */
    public void setSr_updateDate(String sr_updateDate) {
        this.sr_updateDate = sr_updateDate;
    }
}
