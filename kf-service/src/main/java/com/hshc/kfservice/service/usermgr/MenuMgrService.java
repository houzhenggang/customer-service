/**
 * 菜单管理Service
 * 
 * @title: MenuMgrService.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfservice.service.usermgr;

import java.util.List;

import com.hshc.kfpub.base.BaseModel;
import com.hshc.kfpub.model.CommMenuModel;
import com.hshc.kfpub.vo.MenuVo;
import com.hshc.kfservice.service.base.BaseService;

/**
 * 菜单管理Service
 * 
 * @className MenuMgrService
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface MenuMgrService extends BaseService<MenuVo, CommMenuModel> {

    /**
     * 查询所有菜单
     * 
     * @return 返回菜单列表
     */
    List<CommMenuModel> queryAllMenus();

    /**
     * 查询所有菜单，并在该用户拥有的菜单上打标记
     * 
     * @param uid 用户ID
     * @return 返回菜单列表
     */
    List<CommMenuModel> queryAllMenusWithUserFlag(Integer uid);

    /**
     * 只查询出指定用户拥有的菜单
     * 
     * @param uid 用户ID
     * @return 返回菜单列表
     */
    List<CommMenuModel> queryUserMenus(Integer uid);

    /**
     * 根据角色ID查询该角色所拥有的菜单树
     *
     * @param rid 角色ID
     * @return
     * @throws Exception
     */
    List<CommMenuModel> queryMenusByRoleId(Integer rid);

    /**
     * 查询菜单树并且跟制定roleId关联时带出指定的roleId
     *
     * @param roleId 角色id
     * @return 用户对象集合
     */
    List<CommMenuModel> queryMenusWithRoleFlag(Integer roleId);
}
