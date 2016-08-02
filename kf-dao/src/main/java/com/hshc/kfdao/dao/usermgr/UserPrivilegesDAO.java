package com.hshc.kfdao.dao.usermgr;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * user_privileges中间表的dao操作
 *
 * @author 耿长宝
 * @version V1.0 2016-07-30 13:45
 */
public interface UserPrivilegesDAO{

	/**
     * 删除用户的特殊权限
     * 
     * @param userId 用户ID
     * @return 删除记录条数
     */
    int deleteByUserId(Integer userId);

	/**
     * 为用户添加特殊权限
     * 
     * @param userId 用户ID
     * @param privilegesList 多个特权
     * @return 插入记录条数
     */
    int insertPrivilegesWithUserId(@Param("userId") Integer userId, @Param("privilegesList") List  privilegesList);
}
