package com.leixindi.service;

import com.leixindi.bean.AdminInfo;

/**
 * ����Ա�ķ�����Ľӿ�-- ����Ա�ķ���ģ��
 */
public interface AdminService {

    /**
     * ����Ա��¼�Ĳ�ѯ
     *
     * @param ad_uName ����Ա�û���
     * @param ad_pwd   ����Ա����
     * @return ����Ա��
     */
    public AdminInfo adminLogin(String ad_uName, String ad_pwd);
}
