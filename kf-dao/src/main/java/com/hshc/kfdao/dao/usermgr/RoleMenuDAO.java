package com.hshc.kfdao.dao.usermgr;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * role_menu中间表的dao操作
 *
 * @author 钟林俊
 * @version V1.0 2016-07-30 13:18
 */
public interface RoleMenuDAO {

    /**
     * 物理删除指定roleId的所有记录
     *
     * @param roleId 角色id
     * @return 删除记录的数量
     */
    int deleteByRoleId(Integer roleId);

    /**
     * 插入多条关联指定roleId的menuId记录
     *
     * @param menuList 菜单对象集合
     * @param roleId 角色id
     * @return 插入记录的数量
     */
    int insertMenusWithRoleId(@Param("menuList") List menuList, Integer roleId);
}
