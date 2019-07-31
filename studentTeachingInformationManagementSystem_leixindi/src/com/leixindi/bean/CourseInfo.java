package com.leixindi.bean;

/**
 * 课程信息类
 */
public class CourseInfo {
    /**
     * 课程编号
     */
    private int c_id;
    /**
     * 课程名称
     */
    private String c_name;
    /**
     * 课程学分
     */
    private int c_credit;
    /**
     * 管理员编号
     */
    private int ad_id;
    /**
     * 该课程创建时间
     */
    private String c_createDate;

    /**
     * 该课程更新时间
     */
    private String c_updateDate;

    /**
     * 课程状态
     */
    private String c_state;

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
     * 获取课程名称
     *
     * @return 课程名称
     */
    public String getC_name() {
        return c_name;
    }

    /**
     * 设置课程名称
     *
     * @param c_name 课程名称
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    /**
     * 获取课程学分
     *
     * @return 课程学分
     */
    public int getC_credit() {
        return c_credit;
    }

    /**
     * 设置课程学分
     *
     * @param c_credit 课程学分
     */
    public void setC_credit(int c_credit) {
        this.c_credit = c_credit;
    }

    /**
     * 获取管理员编号
     *
     * @return 管理员编号
     */
    public int getAd_id() {
        return ad_id;
    }

    /**
     * 设置管理员编号
     *
     * @param ad_id 管理员编号
     */
    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    /**
     * 获取课程创建时间
     *
     * @return 返回课程创建时间
     */
    public String getC_createDate() {
        return c_createDate;
    }

    /**
     * 设置课程创建时间
     *
     * @param c_createDate 返回课程创建时间
     */
    public void setC_createDate(String c_createDate) {
        this.c_createDate = c_createDate;
    }

    /**
     * 获取课程修改时间
     *
     * @return 课程修改时间
     */
    public String getC_updateDate() {
        return c_updateDate;
    }

    /**
     * 设置课程修改时间
     *
     * @param c_updateDate 课程修改时间
     */
    public void setC_updateDate(String c_updateDate) {
        this.c_updateDate = c_updateDate;
    }

    /**
     * 获取课程状态
     *
     * @return 课程状态
     */
    public String getC_state() {
        return c_state;
    }

    /**
     * 返回课程状态
     *
     * @param c_state 课程状态
     */
    public void setC_state(String c_state) {
        this.c_state = c_state;
    }
}
