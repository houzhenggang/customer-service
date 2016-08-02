/**
 * 用户管理
 * 
 * @title: DeptMgrServiceImpl.java
 * @author 耿长宝
 * @date 2016年7月30日
 */
package com.hshc.kfserviceproviders.service.usermgr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.hshc.kfpub.vo.DeptVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hshc.kfdao.dao.usermgr.DeptDAO;
import com.hshc.kfdao.dao.usermgr.DeptUserDAO;
import com.hshc.kfdao.dao.usermgr.PrivilegeDAO;
import com.hshc.kfdao.dao.usermgr.RoleDAO;
import com.hshc.kfdao.dao.usermgr.UserDAO;
import com.hshc.kfdao.dao.usermgr.UserRoleDAO;
import com.hshc.kfpub.model.CommDeptModel;
import com.hshc.kfpub.model.CommLoginModel;
import com.hshc.kfservice.service.usermgr.DeptMgrService;

/**
 * 用户管理
 * 
 * @className DeptMgrServiceImpl
 * @author 耿长宝
 * @version V1.0 2016年7月30日
 */
@Service
public class DeptMgrServiceImpl implements DeptMgrService {
	
	@Resource
	private UserDAO userDao; // 用户DAO
	@Resource
	private DeptDAO deptDao; // 用户DAO
	@Resource
    private RoleDAO roleDao; // 角色DAO
    @Resource
    private PrivilegeDAO privilegeDao; // 特殊权限DAO
    @Resource
    private UserRoleDAO userRoleDao; //用户权限关联DAO
    @Resource
    private DeptUserDAO deptUserDao; //部门与用户的关联DAO
    
    /**
     * 根据ID查询部门信息
     * 
     * @param id
     * @return
     */
	@Override
	public CommDeptModel queryById(Integer deptId) {
		if (deptId == null) {
			 throw new RuntimeException("部门ID不能为空！");
		}
		return deptDao.selectById(deptId);
	}
	
    /**
     * 根据查询条件，分页查询记录
     * 
     * @param param
     * @return
     */
	@Override
	public List<CommDeptModel> queryByParams(DeptVo dept) {
		if (dept == null) {
			 throw new RuntimeException("部门对象不能为空！");
		}
		return deptDao.selectByParams(dept);
	}
	
	/**
     * 新增记录
     * 
     * @param m 用户登录表实体类
     * @return 返回成功条数
     */
	@Override
	public int add(CommDeptModel dept) {
		if (dept == null) {
			 throw new RuntimeException("部门对象不能为空！");
		}
		return deptDao.insert(dept);
	}
	
	/**
     * 批量添加记录
     * 
     * @param list 待添加的记录集合
     * @return 返回成功条数
     */
	@Override
	public int addBatch(List<CommDeptModel> deptList) {
		if (deptList == null) {
			 throw new RuntimeException("部门对象不能为空！");
		}
		  int rows = 0;
	        if(!CollectionUtils.isEmpty(deptList)){
	            for(CommDeptModel dept : deptList){
	                rows += add(dept);
	            }
	        }
		return rows;
	}
	
	/**
     * 更新记录
     * 
     * @param m 待更新实体
     * @return 返回成功条数
     */
	@Override
	public int modify(CommDeptModel dept) {
		if (dept == null) {
			 throw new RuntimeException("部门对象不能为空！");
		}
		return deptDao.update(dept);
	}
	
    /**
     * 根据ID删除记录
     * 
     * @param id 记录ID
     * @return 返回成功条数
     */
	@Override
	public int remove(Integer deptId) {
		if (deptId == null) {
			 throw new RuntimeException("部门ID不能为空！");
		}
		// 获取部门信息
		CommDeptModel  dept = deptDao.selectById(deptId);
		// 获取该部门下面的所有用户信息
		List<CommLoginModel> loginUserList  = dept.getLoginUserList();
		if (loginUserList != null && loginUserList.size() != 0) {
			throw new RuntimeException("该部门已有用户不能删除！");
		}
		return deptDao.deleteById(deptId);
	}
	
    /**
     * 根据条件批量删除
     * 
     * @param list
     * @return 返回成功条数
     */
	@Override
	public int removeBatch(String deptIds) {
		if (deptIds == null) {
			 throw new RuntimeException("部门ID不能为空！");
		}
		String deptId[] = deptIds.split(",");
		List<Integer> deptIdList = new ArrayList<>();
		for (int i=0; i< deptId.length; i++) {
			deptIdList.add(Integer.valueOf(deptId[i]));
		}
	     int rows = 0;
	        if(!CollectionUtils.isEmpty(deptIdList)){
	            for(Integer uId : deptIdList){
	                rows += remove(uId);
	            }
	        }
	   return rows;
	}
	
    /**
     * 把用户添加到指定部门
     * 
     * @param did 部门ID
     * @param uid 用户ID
     * @return String 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
	@Override
	public String addDeptUser(Integer did, Integer uid) {
		if (did == null) {
			 throw new RuntimeException("部门ID不能为空！");
		}
		if (uid == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		//先删除该用户与该部门的关联关系    防止二次关联
		deptUserDao.deleteUserWithDept(did, uid);
		//重新建立该用户与该部门的关联关系
		int i = deptUserDao.insertUserWithDept(did, uid);
		if (i == 0) {
			return "指定部门失败！";
		}
		return null;
	}
	
    /**
     * 保存用户部门关联，支持一个用户多个部门
     * 
     * @param uid 用户ID
     * @param dids 部门ID，多个ID用英文逗号隔开
     * @return String 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
	@Override
	public String saveUserDepts(Integer uid, String dids) {
		if (uid == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		if (dids == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		String did[] = dids.split(",");
		if (did.length == 0) {
			 throw new RuntimeException("至少为用户设置一个权限！");
		}
		List<Integer> didList = new ArrayList<>();
		for (int i=0; i< did.length; i++) {
			didList.add(Integer.valueOf(did[i]));
		}
		deptUserDao.deleteDeptsWithUser(uid);
		deptUserDao.insertDeptsWithUser(uid, didList);
		return null;
	}
	
    /**
     * 用户调动所属部门
     * 
     * @param uid 待调动用户ID
     * @param sourceDeptId 目前所属部门ID
     * @param targetDeptId 移动到目标部门ID
     * @return String 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
	@Override
	public String handleUserDeptMove(Integer uid, Integer sourceDeptId, Integer targetDeptId) {
		if (uid == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		if (sourceDeptId == null) {
			 throw new RuntimeException("目前所属部门ID不能为空！");
		}
		if (targetDeptId == null) {
			 throw new RuntimeException("移动到目标部门ID不能为空！");
		}
		int i = deptUserDao.updateDeptWithUser(uid, sourceDeptId, targetDeptId);
		if (i == 0) {
			return "调用失败！";
		}
		return null;
	}

    /**
     * 部门调动所属部门
     * 
     * @param deptId 待调动部门ID
     * @param sourceDeptId 目前所属部门ID
     * @param targetDeptId 移动到目标部门ID
     * @return 如果有错误，则为错误信息，否则，返回null
     * @throws Exception
     */
	@Override
	public String handleDeptMove(Integer deptId, Integer targetDeptId) {
		if (deptId == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		if (targetDeptId == null) {
			 throw new RuntimeException("移动到目标部门ID不能为空！");
		}
		CommDeptModel dept = new CommDeptModel();
		dept.setId(deptId);
		CommDeptModel parentDept = new CommDeptModel();
		parentDept.setId(targetDeptId);
		dept.setParentDept(parentDept);
		int i = deptDao.update(dept);
		if (i == 0) {
			return "部门调动所属部门失败！";
		}
		return null;
	}
    /**
     * 根据父部门ID查询子部门树
     * 
     * @param pid 父部门ID，如果不指定或为0，则查询整个部门树
     * @return 部门列表
     * @throws Exception
     */
	@Override
	public List<CommDeptModel> queryDeptTreeByDid(Integer pid) {
		
		return deptDao.selectDeptTreeByDid(pid);
	}
  

}
