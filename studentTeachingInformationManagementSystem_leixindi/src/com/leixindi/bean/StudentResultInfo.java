package com.leixindi.bean;

/**
 * ѧ���ɼ���Ϣ��
 */
public class StudentResultInfo {
    /**
     * �ɼ��ı��
     */
    private int sr_id;
    /**
     * ѧ�����
     */
    private int stu_id;
    /**
     * �γ̳ɼ�
     */
    private int sr_result;
    /**
     * �γ̱��
     */
    private int c_id;
    /**
     * ��ʦ����
     */
    private int tea_id;
    /**
     * �ɼ��Ĵ���ʱ��
     */
    private String sr_createDate;
    /**
     * �ɼ��ĸ���ʱ��
     */
    private String sr_updateDate;
    /**
     * ��ȡѧ�����
     *
     * @return ѧ�����
     */
    public int getStu_id() {
        return stu_id;
    }

    /**
     * ����ѧ�����
     *
     * @param stu_id ѧ�����
     */
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
    /**
     * ��ȡѧ���γ̳ɼ�
     *
     * @return ��ȡѧ���γ̳ɼ�
     */
    public int getSr_result() {
        return sr_result;
    }

    /**
     * ����ѧ���γ̳ɼ�
     *
     * @param sr_result ѧ���γ̳ɼ�
     */
    public void setSr_result(int sr_result) {
        this.sr_result = sr_result;
    }

    /**
     * ��ȡ�ɼ����
     *
     * @return �ɼ����
     */
    public int getSr_id() {
        return sr_id;
    }

    /**
     * ���óɼ����
     *
     * @param sr_id �ɼ����
     */
    public void setSr_id(int sr_id) {
        this.sr_id = sr_id;
    }

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
     * ��ȡ�ɼ�����ʱ��
     *
     * @return �ɼ�����ʱ��
     */
    public String getSr_createDate() {
        return sr_createDate;
    }

    /**
     * ���óɼ�����ʱ��
     *
     * @param sr_createDate �ɼ�����ʱ��
     */
    public void setSr_createDate(String sr_createDate) {
        this.sr_createDate = sr_createDate;
    }

    /**
     * ��ȡ�ɼ�����ʱ��
     *
     * @return �ɼ�����ʱ��
     */
    public String getSr_updateDate() {
        return sr_updateDate;
    }

    /**
     * ���óɼ�����ʱ��
     *
     * @param sr_updateDate �ɼ�����ʱ��
     */
    public void setSr_updateDate(String sr_updateDate) {
        this.sr_updateDate = sr_updateDate;
    }

    /**
     * ��ȡ��ʦ���
     *
     * @return ��ʦ���
     */
    public int getTea_id() {
        return tea_id;
    }

    /**
     * ���ý�ʦ���
     *
     * @param tea_id ��ʦ���
     */
    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }
}
