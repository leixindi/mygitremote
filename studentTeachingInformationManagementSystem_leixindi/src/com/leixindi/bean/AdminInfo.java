package com.leixindi.bean;

/**
 * ����Ա��Ϣ��
 */
public class AdminInfo {
    /**
     * ����Ա���
     */
    private int ad_id;
    /**
     * ����Ա�˺�
     */
    private String ad_uName;
    /**
     * ����Ա����
     */
    private String ad_pwd;

    /**
     * ��ȡ����Ա���
     *
     * @return ����Ա���
     */
    public int getAd_id() {
        return ad_id;
    }

    /**
     * ���ù���Ա���
     *
     * @param ad_id ����Ա���
     */
    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    /**
     * ��ȡ����Ա�˺�
     *
     * @return ����Ա�˺�
     */
    public String getAd_uName() {
        return ad_uName;
    }

    /**
     * ���ù���Ա�û���
     *
     * @param ad_uName ����Ա�û���
     */
    public void setAd_uName(String ad_uName) {
        this.ad_uName = ad_uName;
    }

    /**
     * ��ȡ����Ա����
     *
     * @return ����Ա����
     */
    public String getAd_pwd() {
        return ad_pwd;
    }

    /**
     * ���ù���Ա����
     *
     * @param ad_pwd ����Ա����
     */
    public void setAd_pwd(String ad_pwd) {
        this.ad_pwd = ad_pwd;
    }
}
