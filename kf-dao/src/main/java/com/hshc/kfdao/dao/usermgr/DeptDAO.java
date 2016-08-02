/**
 * 部门管理DAO
 * 
 * @title: DeptDAO.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfdao.dao.usermgr;

import java.util.List;

import com.hshc.kfdao.dao.base.BaseDAO;
import com.hshc.kfpub.model.CommDeptModel;
import com.hshc.kfpub.vo.DeptVo;

/**
 * 部门管理DAO
 * 
 * @className DeptDAO
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface DeptDAO  extends BaseDAO<DeptVo, CommDeptModel> {
    /**
     * 根据父部门ID查询子部门树
     *
     * @param deptId 部门ID
     * @param targetDeptId 所属部门ID
     * @return 更新记录的数量
     */
    List<CommDeptModel> selectDeptTreeByDid(Integer deptId);
}
