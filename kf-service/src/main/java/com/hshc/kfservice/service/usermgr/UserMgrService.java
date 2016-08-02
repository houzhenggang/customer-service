/**
 * 用户管理Service
 * 
 * @title: UserMgrService.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfservice.service.usermgr;

import com.hshc.kfpub.model.CommLoginModel;
import com.hshc.kfpub.vo.LoginVo;
import com.hshc.kfservice.service.base.BaseService;

import java.util.List;

/**
 * 用户管理Service
 * 
 * @className UserMgrService
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface UserMgrService extends BaseService<LoginVo, CommLoginModel> {

    /**
     * 根据角色ID查询拥有该角色的用户列表
     *
     * @param rid 角色ID
     * @return 用户列表
     * @throws Exception
     */
    List<CommLoginModel> queryUsersByRoleId(Integer rid);

    /**
     * 保存用户与角色的关联关系
     * 
     * @param uid 用户ID
     * @param rids 角色ID，多个用英文逗号分隔
     * @throws Exception
     */
    void saveRolesUserRel(Integer uid, String rids);

    /**
     * 保存用户的特权信息
     *
     * @param uid 用户ID
     * @param pids 权限ID，多个用英文逗号分隔
     * @throws Exception
     */
    void savePrivilegesUserRel(Integer uid, String pids);

    /**
     * 查询所有用户并且跟指定roleId关联时带出指定的roleId
     *
     * @param roleId 角色id
     * @return 用户对象集合
     */
    List<CommLoginModel> queryUsersWithRoleFlag(Integer roleId);
}
