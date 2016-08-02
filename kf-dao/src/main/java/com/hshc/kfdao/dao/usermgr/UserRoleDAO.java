package com.hshc.kfdao.dao.usermgr;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * user_role中间表的dao操作
 *
 * @author 钟林俊
 * @version V1.0 2016-07-30 13:45
 */
public interface UserRoleDAO{

    /**
     * 查询对应roleId的userId数量
     *
     * @param roleId 角色id
     * @return userId的数量
     */
    int countUsersByRoleId(Integer roleId);

    /**
     * 物理删除指定roleId的所有记录
     *
     * @param roleId 角色id
     * @return 删除记录的数量
     */
    int deleteByRoleId(Integer roleId);

    /**
     * 物理删除指定userId的所有记录
     *
     * @param userId 用户id
     * @return 删除记录的数量
     */
    int deleteByUserId(Integer userId);

    /**
     * 插入多条关联指定roleId的userId记录
     *
     * @param userList user对象集合
     * @param roleId 角色id
     * @return 插入记录的数量
     */
    int insertUsersWithRoleId(@Param("userList") List userList, @Param("roleId") Integer roleId);

    /**
     * 插入多条关联指定userId的roleId记录
     *
     * @param userId 用户id
     * @param roleList 角色对象集合
     * @return 插入记录的数量
     */
    int insertRolesWithUserId(@Param("userId") Integer userId, @Param("roleIdList") List  roleList);
}
