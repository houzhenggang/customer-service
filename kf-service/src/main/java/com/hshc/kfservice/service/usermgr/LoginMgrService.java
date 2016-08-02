/**
 * 登录Service
 * 
 * @title: LoginService.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfservice.service.usermgr;

import com.hshc.kfpub.model.CommLoginModel;
import com.hshc.kfpub.vo.LoginVo;
import com.hshc.kfservice.service.base.BaseService;

/**
 * 登录Service
 * 
 * @className LoginService
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface LoginMgrService{

    /**
     * 登录操作
     * 
     * @param loginName 登录名
     * @param loginPwd 登录密码
     * @return String 如果有错误，则为错误信息，否则，返回null
     */
    String handleLogin(String loginName, String loginPwd);

    /**
     * 注销操作
     */
    void logout();

    /**
     * 修改密码
     * 
     * @param loginName 登录名
     * @param oldPwd
     * @param newPwd
     * @return String 如果有错误，则为错误信息，否则，返回null
     */
    String modifyPwd(String loginName, String oldPwd, String newPwd);

    /**
     * 重置密码
     * 
     * @param loginName 登录名
     * @return String 如果有错误，则为错误信息，否则，返回null
     */
    String handlePwdReset(String loginName);
}
