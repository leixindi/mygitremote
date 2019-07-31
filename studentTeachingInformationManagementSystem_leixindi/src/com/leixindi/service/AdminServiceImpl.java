package com.leixindi.service;

import com.leixindi.bean.AdminInfo;
import com.leixindi.dao.AdminDao;
import com.leixindi.dao.AdminDaoImpl;

/**
 * 管理员的业务层的实现 -- 管理员的服务模块
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    /**
     * 管理员登录的查询
     *
     * @param ad_uName 管理员用户名
     * @param ad_pwd 管理员密码
     * @return 管理员类
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
