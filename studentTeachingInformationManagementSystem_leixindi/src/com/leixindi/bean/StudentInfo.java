package com.leixindi.bean;

/**
 * 学生基本信息类
 */
public class StudentInfo {
    /**
     * 学生编号
     */
    private int stu_id;
    /**
     * 学生用户名
     */
    private String stu_uName;
    /**
     * 学生密码
     */
    private String stu_pwd;
    /**
     * 学生姓名
     */
    private String stu_name;
    /**
     * 学生性别
     */
    private String stu_sex;
    /**
     * 学生年龄
     */
    private int stu_age;
    /**
     * 学生电话号码
     */
    private String stu_phone;
    /**
     * 学生专业
     */
    private String stu_major;
    /**
     * 管理员编号
     */
    private int ad_id;
    /**
     * 学生信息创建时间
     */
    private String stu_createDate;
    /**
     * 学生信息修改时间
     */
    private String stu_updateDate;
    /**
     * 该学生的状态
     */
    private String stu_state;

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
     * @param stu_id 编号
     */
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    /**
     * 获取学生用户名
     *
     * @return 学生用户名
     */
    public String getStu_uName() {
        return stu_uName;
    }

    /**
     * 设置学生账号
     *
     * @param stu_uName 学生账号
     */
    public void setStu_uName(String stu_uName) {
        this.stu_uName = stu_uName;
    }

    /**
     * 获取学生密码
     *
     * @return 学生密码
     */
    public String getStu_pwd() {
        return stu_pwd;
    }

    /**
     * 设置学生密码
     *
     * @param stu_pwd 学生密码
     */
    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

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
     * 获取学生性别
     *
     * @return 学生性别
     */
    public String getStu_sex() {
        return stu_sex;
    }

    /**
     * 设置学生性别
     *
     * @param stu_sex 学生性别
     */
    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    /**
     * 获取学生年龄
     *
     * @return 学生年龄
     */
    public int getStu_age() {
        return stu_age;
    }

    /**
     * 设置学生年龄
     *
     * @param stu_age 学生年龄
     */
    public void setStu_age(int stu_age) {
        this.stu_age = stu_age;
    }

    /**
     * 获取学生电话
     *
     * @return 学生电话
     */
    public String getStu_phone() {
        return stu_phone;
    }

    /**
     * 设置学生电话
     *
     * @param stu_phone 学生电话
     */
    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    /**
     * 获取学生专业
     *
     * @return 学生专业
     */
    public String getStu_major() {
        return stu_major;
    }

    /**
     * 设置学生专业
     *
     * @param stu_major 学生专业
     */
    public void setStu_major(String stu_major) {
        this.stu_major = stu_major;
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
     * 返回学生信息创建时间
     *
     * @return 学生信息创建时间
     */
    public String getStu_createDate() {
        return stu_createDate;
    }

    /**
     * 设置学生信息创建时间
     *
     * @param stu_createDate 学生信息创建时间
     */
    public void setStu_createDate(String stu_createDate) {
        this.stu_createDate = stu_createDate;
    }

    /**
     * 获取学生信息修改时间
     *
     * @return 学生信息修改时间
     */
    public String getStu_updateDate() {
        return stu_updateDate;
    }

    /**
     * 设置学生信息修改时间
     *
     * @param stu_updateDate 学生信息修改时间
     */
    public void setStu_updateDate(String stu_updateDate) {
        this.stu_updateDate = stu_updateDate;
    }

    /**
     * 获取该学生的状态
     *
     * @return 学生的状态
     */
    public String getStu_state() {
        return stu_state;
    }

    /**
     * 获取该学生的状态
     *
     * @param stu_state 学生的状态
     */
    public void setStu_state(String stu_state) {
        this.stu_state = stu_state;
    }
}
