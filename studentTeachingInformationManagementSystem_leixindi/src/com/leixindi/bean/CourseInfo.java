package com.leixindi.bean;

/**
 * �γ���Ϣ��
 */
public class CourseInfo {
    /**
     * �γ̱��
     */
    private int c_id;
    /**
     * �γ�����
     */
    private String c_name;
    /**
     * �γ�ѧ��
     */
    private int c_credit;
    /**
     * ����Ա���
     */
    private int ad_id;
    /**
     * �ÿγ̴���ʱ��
     */
    private String c_createDate;

    /**
     * �ÿγ̸���ʱ��
     */
    private String c_updateDate;

    /**
     * �γ�״̬
     */
    private String c_state;

    /**
     * ��ȡ�γ̱��
     *
     * @return �γ̱��
     */
    public int getC_id() {
        return c_id;
    }

    /**
     * ���ÿγ̱��
     *
     * @param c_id �γ̱��
     */
    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    /**
     * ��ȡ�γ�����
     *
     * @return �γ�����
     */
    public String getC_name() {
        return c_name;
    }

    /**
     * ���ÿγ�����
     *
     * @param c_name �γ�����
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    /**
     * ��ȡ�γ�ѧ��
     *
     * @return �γ�ѧ��
     */
    public int getC_credit() {
        return c_credit;
    }

    /**
     * ���ÿγ�ѧ��
     *
     * @param c_credit �γ�ѧ��
     */
    public void setC_credit(int c_credit) {
        this.c_credit = c_credit;
    }

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
     * ��ȡ�γ̴���ʱ��
     *
     * @return ���ؿγ̴���ʱ��
     */
    public String getC_createDate() {
        return c_createDate;
    }

    /**
     * ���ÿγ̴���ʱ��
     *
     * @param c_createDate ���ؿγ̴���ʱ��
     */
    public void setC_createDate(String c_createDate) {
        this.c_createDate = c_createDate;
    }

    /**
     * ��ȡ�γ��޸�ʱ��
     *
     * @return �γ��޸�ʱ��
     */
    public String getC_updateDate() {
        return c_updateDate;
    }

    /**
     * ���ÿγ��޸�ʱ��
     *
     * @param c_updateDate �γ��޸�ʱ��
     */
    public void setC_updateDate(String c_updateDate) {
        this.c_updateDate = c_updateDate;
    }

    /**
     * ��ȡ�γ�״̬
     *
     * @return �γ�״̬
     */
    public String getC_state() {
        return c_state;
    }

    /**
     * ���ؿγ�״̬
     *
     * @param c_state �γ�״̬
     */
    public void setC_state(String c_state) {
        this.c_state = c_state;
    }
}
