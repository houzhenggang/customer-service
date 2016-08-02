/**
 * 角色管理DAO
 * 
 * @title: RoleDAO.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfdao.dao.usermgr;

import java.util.List;

import com.hshc.kfdao.dao.base.BaseDAO;
import com.hshc.kfpub.model.CommRoleModel;
import com.hshc.kfpub.vo.RoleVo;
import org.springframework.stereotype.Repository;

/**
 * 角色管理DAO
 * 
 * @className RoleDAO
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface RoleDAO extends BaseDAO<RoleVo, CommRoleModel> {

    List<CommRoleModel> selectRolesByUserId(Integer userId);
}
