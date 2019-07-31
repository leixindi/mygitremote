package com.leixindi.service;

import com.leixindi.bean.AdminInfo;

/**
 * 管理员的服务类的接口-- 管理员的服务模块
 */
public interface AdminService {

    /**
     * 管理员登录的查询
     *
     * @param ad_uName 管理员用户名
     * @param ad_pwd   管理员密码
     * @return 管理员类
     */
    public AdminInfo adminLogin(String ad_uName, String ad_pwd);
}
