package com.leixindi.bean;

/**
 * 管理员信息类
 */
public class AdminInfo {
    /**
     * 管理员编号
     */
    private int ad_id;
    /**
     * 管理员账号
     */
    private String ad_uName;
    /**
     * 管理员密码
     */
    private String ad_pwd;

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
     * 获取管理员账号
     *
     * @return 管理员账号
     */
    public String getAd_uName() {
        return ad_uName;
    }

    /**
     * 设置管理员用户名
     *
     * @param ad_uName 管理员用户名
     */
    public void setAd_uName(String ad_uName) {
        this.ad_uName = ad_uName;
    }

    /**
     * 获取管理员密码
     *
     * @return 管理员密码
     */
    public String getAd_pwd() {
        return ad_pwd;
    }

    /**
     * 设置管理员密码
     *
     * @param ad_pwd 管理员密码
     */
    public void setAd_pwd(String ad_pwd) {
        this.ad_pwd = ad_pwd;
    }
}
