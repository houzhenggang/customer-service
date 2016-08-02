/**
 * 权限管理DAO
 * 
 * @title: PrivilegeDAO.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfdao.dao.usermgr;

import java.util.List;

import com.hshc.kfdao.dao.base.BaseDAO;
import com.hshc.kfpub.model.CommPrivilegesModel;
import com.hshc.kfpub.vo.PrivilegeVo;
import org.springframework.stereotype.Repository;

/**
 * 权限管理DAO
 * 
 * @className PrivilegeDAO
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface PrivilegeDAO extends BaseDAO<PrivilegeVo, CommPrivilegesModel> {

    List<CommPrivilegesModel> selectPrivilegesByRoleId(Integer roleId);

    List<CommPrivilegesModel> selectPrivilegesWithRoleFlag(Integer roleId);
}
