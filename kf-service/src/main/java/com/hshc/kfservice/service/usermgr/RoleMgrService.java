/**
 * 角色管理Service
 * 
 * @title: RoleMgrService.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfservice.service.usermgr;

import java.util.List;

import com.hshc.kfpub.model.CommRoleModel;
import com.hshc.kfpub.vo.RoleVo;
import com.hshc.kfservice.service.base.BaseService;

/**
 * 角色管理Service
 * 
 * @className RoleMgrService
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface RoleMgrService extends BaseService<RoleVo, CommRoleModel> {

    /**
     * 保存角色的权限关联信息
     * 
     * @param rid 角色ID
     * @throws Exception
     */
    void savePrivilegesRole(Integer rid);

    /**
     * 删除该角色与用户的所有关联
     * 
     * @param rid 角色ID
     * @throws Exception
     */
    void removeAllUserRelByRoleId(Integer rid);

    /**
     * 删除该角色与权限的所有关联
     *
     * @param rid 角色ID
     * @throws Exception
     */
    void removeAllPrivilegeRelByRoleId(Integer rid);

    /**
     * 所有角色信息，并标记出该用户所拥有的角色
     *
     * @param uid 用户ID
     * @return 返回角色列表
     * @throws Exception
     */
    List<CommRoleModel> queryAllRolesByUserId(Integer uid);
}
