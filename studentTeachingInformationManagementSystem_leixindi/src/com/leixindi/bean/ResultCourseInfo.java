package com.leixindi.bean;

/**
 * ����ѧ������ʦ���ɼ���Ϳγ̱�����ϲ�ѯ
 */
public class ResultCourseInfo {
    /**
     * �ɼ��ı��
     */
    private int sr_id;
    /**
     * ѧ������
     */
    private String stu_name;
    /**
     * �γ̳ɼ�
     */
    private int sr_result;
    /**
     * �γ�����
     */
    private String c_name;
    /**
     * ��ʦ����
     */
    private String tea_name;
    /**
     * �ɼ��Ĵ���ʱ��
     */
    private String sr_createDate;
    /**
     * �ɼ��ĸ���ʱ��
     */
    private String sr_updateDate;

    /**
     * ��ȡѧ������
     *
     * @return ѧ������
     */
    public String getStu_name() {
        return stu_name;
    }

    /**
     * ����ѧ������
     *
     * @param stu_name ѧ������
     */
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
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
    public String getC_name() {
        return c_name;
    }

    /**
     * ���ÿγ̱��
     *
     * @param c_name �γ̱��
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    /**
     * ��ȡ��ʦ���
     *
     * @return �γ̱��
     */
    public String getTea_name() {
        return tea_name;
    }

    /**
     * ���ÿγ̱��
     *
     * @param tea_name �γ̱��
     */
    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
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
}
