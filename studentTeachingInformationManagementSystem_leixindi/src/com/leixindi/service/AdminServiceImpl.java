package com.leixindi.service;

import com.leixindi.bean.AdminInfo;
import com.leixindi.dao.AdminDao;
import com.leixindi.dao.AdminDaoImpl;

/**
 * ����Ա��ҵ����ʵ�� -- ����Ա�ķ���ģ��
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    /**
     * ����Ա��¼�Ĳ�ѯ
     *
     * @param ad_uName ����Ա�û���
     * @param ad_pwd ����Ա����
     * @return ����Ա��
     */
    @Override
    public AdminInfo adminLogin(String ad_uName, String ad_pwd) {
        AdminInfo adminInfo = null;
        try {
            adminInfo = adminDao.adminLogin(ad_uName,ad_pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminInfo;
    }
}
