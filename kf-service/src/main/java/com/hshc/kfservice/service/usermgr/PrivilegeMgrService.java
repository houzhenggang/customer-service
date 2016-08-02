/**
 * 权限管理Service
 * 
 * @title: PrivilegeMgrService.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfservice.service.usermgr;

import java.util.List;

import com.hshc.kfpub.base.BaseModel;
import com.hshc.kfpub.model.CommPrivilegesModel;
import com.hshc.kfpub.vo.PrivilegeVo;
import com.hshc.kfservice.service.base.BaseService;

/**
 * 权限管理Service
 * 
 * @className PrivilegeMgrService
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface PrivilegeMgrService extends BaseService<PrivilegeVo, CommPrivilegesModel> {

    /**
     * 根据角色ID查询该角色所拥有的权限列表
     *
     * @param rid 角色ID
     * @return 权限列表
     * @throws Exception
     */
    List<CommPrivilegesModel> queryPrivilegesByRoleId(Integer rid);

    /**
     * 删除该角色与权限的所有关联
     *
     * @param rid
     * @throws Exception
     */
    void removeAllPrivilegeRelByRoleId(Integer rid);

    /**
     * 保存角色的权限关联信息
     *
     * @param rid 角色ID
     * @throws Exception
     */
    void savePrivilegesRole(Integer rid);

    /**
     * 查询权限树并且跟指定roleId关联时带出指定的roleId
     *
     * @param roleId 角色id
     * @return 用户对象集合
     */
    List<CommPrivilegesModel> queryPrivilegesWithRoleFlag(Integer roleId);
}
