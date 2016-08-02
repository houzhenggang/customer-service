/**
 * 部门管理Service
 * 
 * @title: DeptMgrService.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfservice.service.usermgr;

import java.util.List;

import com.hshc.kfpub.model.CommDeptModel;
import com.hshc.kfpub.vo.DeptVo;
import com.hshc.kfservice.service.base.BaseService;

/**
 * 部门管理Service
 * 
 * @className DeptMgrService
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface DeptMgrService extends BaseService<DeptVo, CommDeptModel> {

    /**
     * 把用户添加到指定部门
     * 
     * @param did 部门ID
     * @param uid 用户ID
     * @return String 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
    String addDeptUser(Integer did, Integer uid);

    /**
     * 保存用户部门关联，支持一个用户多个部门
     * 
     * @param uid 用户ID
     * @param dids 部门ID，多个ID用英文逗号隔开
     * @return String 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
    String saveUserDepts(Integer uid, String dids);

    /**
     * 用户调动所属部门
     * 
     * @param uid 待调动用户ID
     * @param sourceDeptId 目前所属部门ID
     * @param targetDeptId 移动到目标部门ID
     * @return String 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
    String handleUserDeptMove(Integer uid, Integer sourceDeptId, Integer targetDeptId);

    /**
     * 部门调动所属部门
     * 
     * @param deptId 待调动部门ID
     * @param sourceDeptId 目前所属部门ID
     * @param targetDeptId 移动到目标部门ID
     * @return 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
    String handleDeptMove(Integer deptId, Integer targetDeptId);

    /**
     * 根据父部门ID查询子部门树
     * 
     * @param pid 父部门ID，如果不指定或为0，则查询整个部门树
     * @return 部门列表
     * @throws Exception
     */
    List<CommDeptModel> queryDeptTreeByDid(Integer pid);
}
