package com.hshc.kfdao.dao.usermgr;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * role_privilege中间表的dao操作
 *
 * @author 钟林俊
 * @version V1.0 2016-07-30 14:11
 */
public interface RolePrivilegeDAO {

    /**
     * 物理删除指定roleId的所有记录
     *
     * @param roleId 角色id
     * @return 删除记录的数量
     */
    int deleteByRoleId(Integer roleId);

    /**
     * 插入多条关联指定roleId的privId记录
     *
     * @param privList 权限对象集合
     * @param roleId 角色id
     * @return 插入记录的数量
     */
    int insertPrivsWithRoleId(@Param("privList") List privList, @Param("roleId") Integer roleId);
}
