package com.leixindi.bean;

/**
 * 教师信息类
 */
public class TeacherInfo {
    /**
     * 教师编号
     */
    private int tea_id;
    /**
     * 教师账号
     */
    private String tea_uName;
    /**
     * 教师密码
     */
    private String tea_pwd;
    /**
     * 教师姓名
     */
    private String tea_name;
    /**
     * 教师所教专业
     */
    private String tea_major;
    /**
     * 教师信息创建时间
     */
    private String tea_createDate;
    /**
     * 教师信息更新时间
     */
    private String tea_updateDate;
    /**
     * 创建的管理员编号
     */
    private int ad_id;
    /**
     * 该教师的状态
     */
    private String tea_state;

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

    /**
     * 获取教师账号
     *
     * @return 教师账号
     */
    public String getTea_uName() {
        return tea_uName;
    }

    /**
     * 设置教师账号
     *
     * @param tea_uName 教师账号
     */
    public void setTea_uName(String tea_uName) {
        this.tea_uName = tea_uName;
    }

    /**
     * 获取教师密码
     *
     * @return 获取教师密码
     */
    public String getTea_pwd() {
        return tea_pwd;
    }

    /**
     * 设置教师密码
     *
     * @param tea_pwd 教师密码
     */
    public void setTea_pwd(String tea_pwd) {
        this.tea_pwd = tea_pwd;
    }

    /**
     * 获取教师姓名
     *
     * @return 教师姓名
     */
    public String getTea_name() {
        return tea_name;
    }

    /**
     * 设置教师姓名
     *
     * @param tea_name 教师姓名
     */
    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    /**
     * 获取教师所授专业
     *
     * @return 教师所授专业
     */
    public String getTea_major() {
        return tea_major;
    }

    /**
     *设置教师所授专业
    *
     * @param tea_major 教师所授专业
     */
    public void setTea_major(String tea_major) {
        this.tea_major = tea_major;
    }

    /**
     * 获取教师信息创建时间
     *
     * @return 教师信息创建时间
     */
    public String getTea_createDate() {
        return tea_createDate;
    }

    /**
     * 设置教师信息创建时间
     *
     * @param tea_createDate 教师信息创建时间
     */
    public void setTea_createDate(String tea_createDate) {
        this.tea_createDate = tea_createDate;
    }

    /**
     * 返回教师信息更新时间
     *
     * @return 教师信息更新时间
     */
    public String getTea_updateDate() {
        return tea_updateDate;
    }

    /**
     * 设置教师信息更新时间
     *
     * @param tea_updateDate 教师信息更新时间
     */
    public void setTea_updateDate(String tea_updateDate) {
        this.tea_updateDate = tea_updateDate;
    }

    /**
     * 返回管理员编号
     *
     * @return 管理员编号
     */
    public int getAd_id() {
        return ad_id;
    }

    /**
     * 返回管理员编号
     *
     * @param ad_id 管理员编号
     */
    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    /**
     * 返回该教师的状态
     *
     * @return 教师的状态
     */
    public String getTea_state() {
        return tea_state;
    }

    /**
     * 设置该教师的状态
     *
     * @param tea_state 教师的状态
     */
    public void setTea_state(String tea_state) {
        this.tea_state = tea_state;
    }
}
