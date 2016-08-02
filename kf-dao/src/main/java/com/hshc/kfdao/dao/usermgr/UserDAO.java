/**
 * 用户管理DAO
 * 
 * @title: UserDAO.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfdao.dao.usermgr;

import com.hshc.kfpub.vo.LoginVo;
import org.apache.ibatis.annotations.Param;

import com.hshc.kfdao.dao.base.BaseDAO;
import com.hshc.kfpub.model.CommLoginModel;

import java.util.List;

/**
 * 用户管理DAO
 * 
 * @className UserDAO
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface UserDAO extends BaseDAO<LoginVo, CommLoginModel> {
	/**
     * 根据用户名查询记录
     * 
     * @param name 用户名
     * @return 返回记录
     */
	CommLoginModel selectByUserName(@Param("loginName") String name);
	
	/**
     * 根据用户名查询密码
     * 
     * @param name 用户名
     * @return 返回记录
     */
	String selectPwdByUserName(@Param("loginName") String name);
	
	/**
     * 修改密码
     * 
     * @param loginName 登录名
     * @param newPwd 新密码
     * @return 更新记录条数
     */
	int updatePwdByUserName(@Param("loginName") String loginName,@Param("newPwd") String newPwd);

	/**
	 * 用指定roleId作为flag查询所有用户
	 *
	 * @param roleId 角色id
	 * @return 用户对象集合
     */
	List<CommLoginModel> selectWithRoleFlag(Integer roleId);

	/**
	 * 根据userList查询未删除的用户数量
	 *
	 * @param loginUserList 用户对象集合
	 * @return 未删除的用户数量
     */
	int countByUserList(List<CommLoginModel> loginUserList);
}
