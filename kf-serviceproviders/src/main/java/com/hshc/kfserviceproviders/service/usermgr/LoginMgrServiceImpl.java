/**
 * 用户管理
 * 
 * @title: LoginMgrServiceImpl.java
 * @author 耿长宝
 * @date 2016年7月30日
 */
package com.hshc.kfserviceproviders.service.usermgr;

import javax.annotation.Resource;

import com.hshc.kfdao.dao.usermgr.PrivilegeDAO;
import com.hshc.kfdao.dao.usermgr.UserDAO;
import com.hshc.kfpub.model.CommLoginModel;
import com.hshc.kfservice.service.usermgr.LoginMgrService;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 * 
 * @className LoginMgrServiceImpl
 * @author 耿长宝
 * @version V1.0 2016年7月30日
 */
@Service
public class LoginMgrServiceImpl implements LoginMgrService {
	
	@Resource
	private UserDAO userDao; // 登录DAO
    @Resource
    private PrivilegeDAO privilegeDao; // 特殊权限DAO
    
    /**
     * 登录操作
     * 
     * @param loginName 登录名
     * @param loginPwd 登录密码
     * @return String 如果有错误，则为错误信息，否则，返回null
     */
	@Override
	public String handleLogin(String loginName, String loginPwd) { //TODO
		if (loginName.isEmpty() || loginPwd.isEmpty()) {
			return "登录名或密码不能为空！";
		}
		CommLoginModel loginMode = userDao.selectByUserName(loginName);
		if (loginMode == null) {
			return "用户不存在！";
		} else if (!loginPwd.equals(loginMode.getLoginPwd())) {
			return "密码错误！";
		}
		
		return null;
	}
	
	
    /**
     * 注销操作
     */
	@Override
	public void logout() {
		// TODO Auto-generated method stub
	}
	
	/**
     * 修改密码
     * 
     * @param loginName 登录名
     * @param oldPwd
     * @param newPwd
     * @return String 如果有错误，则为错误信息，否则，返回null
     */
	@Override
	public String modifyPwd(String loginName, String oldPwd, String newPwd) {
		if (loginName.isEmpty()) {
			throw new RuntimeException("修改密码的用户名不能为空！");
		}
		if (oldPwd.isEmpty()) {
			return "旧密码不能为空！";
		}
		if (newPwd.isEmpty()) {
			return "新密码不能为空！";
		}
		CommLoginModel loginMode = userDao.selectByUserName(loginName);
		if (loginMode == null) {
			throw new RuntimeException("用户不存在!");
		} else if (!oldPwd.equals(loginMode.getLoginPwd())) {
			return "旧密码错误！";
		}
//		int i = userDao.updatePwdByUserName(loginName, newPwd);
//		if (i == 0) {
//			return "密码修改失败";
//		}
		return null;
	}
	
    /**
     * 重置密码
     * 
     * @param loginName 登录名
     * @return String 如果有错误，则为错误信息，否则，返回null
     */
	@Override
	public String handlePwdReset(String loginName) {
		if (loginName.isEmpty()) {
			throw new RuntimeException("修改密码的用户名不能为空！");
		}
//		int i = userDao.updatePwdByUserName(loginName, "123456");
//		if (i == 0) {
//			return "重置密码失败";
//		}
		return null;
	}
}
