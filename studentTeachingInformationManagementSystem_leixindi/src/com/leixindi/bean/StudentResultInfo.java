package com.leixindi.bean;

/**
 * 学生成绩信息类
 */
public class StudentResultInfo {
    /**
     * 成绩的编号
     */
    private int sr_id;
    /**
     * 学生编号
     */
    private int stu_id;
    /**
     * 课程成绩
     */
    private int sr_result;
    /**
     * 课程编号
     */
    private int c_id;
    /**
     * 教师姓名
     */
    private int tea_id;
    /**
     * 成绩的创建时间
     */
    private String sr_createDate;
    /**
     * 成绩的更新时间
     */
    private String sr_updateDate;
    /**
     * 获取学生编号
     *
     * @return 学生编号
     */
    public int getStu_id() {
        return stu_id;
    }

    /**
     * 设置学生编号
     *
     * @param stu_id 学生编号
     */
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
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
    public int getC_id() {
        return c_id;
    }

    /**
     * 设置课程编号
     *
     * @param c_id 课程编号
     */
    public void setC_id(int c_id) {
        this.c_id = c_id;
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

    /**
     * 获取教师编号
     *
     * @return 教师编号
     */
    public int getTea_id() {
        return tea_id;
    }

    /**
     * 设置教师编号
     *
     * @param tea_id 教师编号
     */
    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }
}
