/**
 * 用户管理
 * 
 * @title: UserMgrServiceImpl.java
 * @author 耿长宝
 * @date 2016年7月30日
 */
package com.hshc.kfserviceproviders.service.usermgr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.hshc.kfpub.vo.LoginVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hshc.kfdao.dao.usermgr.PrivilegeDAO;
import com.hshc.kfdao.dao.usermgr.RoleDAO;
import com.hshc.kfdao.dao.usermgr.UserDAO;
import com.hshc.kfdao.dao.usermgr.UserPrivilegesDAO;
import com.hshc.kfdao.dao.usermgr.UserRoleDAO;
import com.hshc.kfpub.model.CommLoginModel;
import com.hshc.kfpub.model.CommRoleModel;
import com.hshc.kfservice.service.usermgr.UserMgrService;

/**
 * 登录
 * 
 * @className UserMgrServiceImpl
 * @author 耿长宝
 * @version V1.0 2016年7月30日
 */
@Service
public class UserMgrServiceImpl implements UserMgrService {
	
	@Resource
	private UserDAO userDao; // 用户DAO
	@Resource
    private RoleDAO roleDao; // 角色DAO
    @Resource
    private PrivilegeDAO privilegeDao; // 特殊权限DAO
    @Resource
    private UserRoleDAO userRoleDao; //用户权限关联DAO
    @Resource
    private UserPrivilegesDAO userPrivilegesDao; //用户权限关联DAO
    
    /**
     * 根据ID查询记录
     * 
     * @param userId
     * @return
     */
	@Override
	public CommLoginModel queryById(Integer userId) {
		if (userId == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		return userDao.selectById(userId);
	}

    /**
     * 根据查询条件，分页查询记录
     * 
     * @param user
     * @return
     */
	@Override
	public List<CommLoginModel> queryByParams(LoginVo user) {
		if (user == null) {
			 throw new RuntimeException("用户对象不能为空！");
		}
		return userDao.selectByParams(user);
	}

    /**
     * 新增记录
     * 
     * @param user 用户登录表实体类
     * @return 返回成功条数
     */
	@Override
	public int add(CommLoginModel user) {
		if (user == null) {
			 throw new RuntimeException("用户对象不能为空！");
		}
		return userDao.insert(user);
	}

	/**
     * 批量添加记录
     * 
     * @param userList 待添加的记录集合
     * @return 返回成功条数
     */
	@Override
	public int addBatch(List<CommLoginModel> userList) {
		if (userList == null) {
			 throw new RuntimeException("用户对象不能为空！");
		}
	     int rows = 0;
	        if(!CollectionUtils.isEmpty(userList)){
	            for(CommLoginModel user : userList){
	                rows += add(user);
	            }
	        }
		return rows;
	}

	/**
     * 更新记录
     * 
     * @param user 待更新实体
     * @return 返回成功条数
     */
	@Override
	public int modify(CommLoginModel user) {
		if (user == null) {
			 throw new RuntimeException("用户对象不能为空！");
		}
		return userDao.update(user);
	}
	
    /**
     * 根据ID删除记录
     * 
     * @param userId 记录ID
     * @return 返回成功条数
     */
	@Override
	public int remove(Integer userId) {
		if (userId == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		userRoleDao.deleteByUserId(userId); //删除该用户与角色的关联
		userPrivilegesDao.deleteByUserId(userId);  //删除该用户与特殊权限的关联
		return userDao.deleteById(userId);  //删除该用户信息
	}

    /**
     * 根据条件批量删除
     * 
     * @param userIds
     * @return 返回成功条数
     */
	@Override
	public int removeBatch(String userIds) {
		if (userIds == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		String userId[] = userIds.split(",");
		List<Integer> userIdList = new ArrayList<Integer>();
		for (int i=0; i< userId.length; i++) {
			userIdList.add(Integer.valueOf(userId[i]));
		}
	     int rows = 0;
	        if(!CollectionUtils.isEmpty(userIdList)){
	            for(Integer uId : userIdList){
	                rows += remove(uId);
	            }
	        }
	   return rows;
	}

    /**
     * 保存用户与角色的关联关系
     * 
     * @param uid 用户ID
     * @param rids 角色ID，多个用英文逗号分隔
     * @throws Exception
     */
	@Override
	public void saveRolesUserRel(Integer uid, String rids) {
		if (uid == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		if (rids == null) {
			 throw new RuntimeException("角色ID不能为空！");
		}
		String rid[] = rids.split(",");
		if (rid.length == 0) {
			 throw new RuntimeException("至少为用户设置一个权限！");
		}
		List<Integer> ridList = new ArrayList<>();
		for (int i=0; i< rid.length; i++) {
			ridList.add(Integer.valueOf(rid[i]));
		}
		
		//清空该用户角色信息
		userRoleDao.deleteByUserId(uid); 
		//为用户添加角色信息
		userRoleDao.insertRolesWithUserId(uid, ridList);
	}

    /**
     * 保存用户的特权信息
     *
     * @param uid 用户ID
     * @param pids 权限ID，多个用英文逗号分隔
     * @throws Exception
     */
	@Override
	public void savePrivilegesUserRel(Integer uid, String pids) {
		if (uid == null) {
			 throw new RuntimeException("用户ID不能为空！");
		}
		if (pids == null) {
			 throw new RuntimeException("权限ID不能为空！");
		}
		String pid[] = pids.split(",");
		if (pid.length == 0) {
			 throw new RuntimeException("至少为用户设置一个权限！");
		}
		List<Integer> pidList = new ArrayList<Integer>();
		for (int i=0; i< pid.length; i++) {
			pidList.add(Integer.valueOf(pid[i]));
		}
		userPrivilegesDao.deleteByUserId(uid); //删除用户特权关联信息
		userPrivilegesDao.insertPrivilegesWithUserId(uid, pidList);//插入用户特权关联信息
	}

	@Override
	public List<CommLoginModel> queryUsersWithRoleFlag(Integer roleId) {
		return userDao.selectWithRoleFlag(roleId);
	}

	/**
     * 根据角色ID查询拥有该角色的用户列表
     *
     * @param rid 角色ID
     * @return 用户列表
     * @throws Exception
     */
	@Override
	public List<CommLoginModel> queryUsersByRoleId(Integer rid) {
		if (rid == null) {
			 throw new RuntimeException("角色ID不能为空！");
		}
		//获取角色信息
		CommRoleModel roleModel =  roleDao.selectById(rid);
		//获取该角色下面的所有用户
		return roleModel.getLoginUserList();
	}
}
