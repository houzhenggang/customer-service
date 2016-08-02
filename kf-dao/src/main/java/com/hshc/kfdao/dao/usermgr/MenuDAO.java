/**
 * 菜单管理DAO
 * 
 * @title: MenuDAO.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfdao.dao.usermgr;

import com.hshc.kfdao.dao.base.BaseDAO;
import com.hshc.kfpub.model.CommMenuModel;
import com.hshc.kfpub.vo.MenuVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理DAO
 * 
 * @className MenuDAO
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface MenuDAO extends BaseDAO<MenuVo, CommMenuModel> {

    List<CommMenuModel> selectAll();

    List<CommMenuModel> selectByUserId(Integer userId);

    List<CommMenuModel> selectByRoleId(Integer roleId);

    List<CommMenuModel> selectWithUserFlag(Integer userId);

    List<CommMenuModel> selectWithRoleFlag(Integer roleId);
}
