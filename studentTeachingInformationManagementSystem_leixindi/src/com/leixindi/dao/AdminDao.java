package com.leixindi.dao;

import com.leixindi.bean.AdminInfo;

/**
 * ����Ա�����ݷ��ʲ�ӿ�-- ����Ա�����ݷ���ģ��
 */
public interface AdminDao {
    /**
     * ���й���Ա��¼�Ĳ�ѯ����
     *
     * @param ad_uName ����Ա�û���
     * @param ad_pwd ����Ա����
     * @return ����Ա��
     * @throws Exception �׳��쳣
     */
    public AdminInfo adminLogin(String ad_uName,String ad_pwd) throws Exception;
}
