package com.leixindi.dao;

import com.leixindi.bean.AdminInfo;

/**
 * 管理员的数据访问层接口-- 管理员的数据访问模块
 */
public interface AdminDao {
    /**
     * 进行管理员登录的查询操作
     *
     * @param ad_uName 管理员用户名
     * @param ad_pwd 管理员密码
     * @return 管理员类
     * @throws Exception 抛出异常
     */
    public AdminInfo adminLogin(String ad_uName,String ad_pwd) throws Exception;
}
