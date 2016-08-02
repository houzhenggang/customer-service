package com.hshc.kfdao.dao.usermgr;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dept_login中间表的dao操作
 *
 * @author 耿长宝
 * @version V1.0 2016-07-30 14:11
 */
public interface DeptUserDAO {

	/**
     * 删除指定用户与指定的部门的关联关系    一对一
     * 
     * @param did 部门ID
     * @param userId 用户ID
     * @return 删除记录条数
     */
    int deleteUserWithDept(@Param("deptId") Integer did, @Param("userId") Integer uid);
    
	/**
     * 添加用户到指定的部门
     * 
     * @param did 部门ID
     * @param userId 用户ID
     * @return 插入记录条数
     */
    int insertUserWithDept(@Param("deptId") Integer did, @Param("userId") Integer uid);
    
	/**
     * 删除指定用户与指定的部门的关联关系    一对多
     * 
     * @param userId 用户ID
     * @return 删除记录条数
     */
    int deleteDeptsWithUser(Integer userId);
    
	/**
     * 保存用户部门关联，支持一个用户多个部门
     * 
     * @param userId 用户ID
     * @param deptIdList 多个部门ID
     * @return 插入记录条数
     */
    int insertDeptsWithUser(@Param("userId") Integer userId, @Param("deptIdList") List  deptIdList);
    
	/**
     * 用户调动所属部门 
     * 
     * @param userId 用户ID
     * @param sourceDeptId 当前所属部门
     * @param targetDeptId 目标所属部门
     * @return 更新记录条数
     */
    int updateDeptWithUser(@Param("userId") Integer userId , @Param("sourceDeptId") Integer sourceDeptId, @Param("targetDeptId") Integer targetDeptId);
}
