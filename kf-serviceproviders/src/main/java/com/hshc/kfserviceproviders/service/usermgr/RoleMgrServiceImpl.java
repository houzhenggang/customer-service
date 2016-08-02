package com.hshc.kfserviceproviders.service.usermgr;

import com.hshc.kfdao.dao.usermgr.*;
import com.hshc.kfpub.exception.BaseException;
import com.hshc.kfpub.model.CommLoginModel;
import com.hshc.kfpub.model.CommMenuModel;
import com.hshc.kfpub.model.CommPrivilegesModel;
import com.hshc.kfpub.model.CommRoleModel;
import com.hshc.kfpub.vo.RoleVo;
import com.hshc.kfservice.service.usermgr.RoleMgrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 角色业务处理
 *
 * @author 钟林俊
 * @version V1.0 2016-07-30 11:34
 */
@Service
public class RoleMgrServiceImpl implements RoleMgrService {

    @Resource
    private RoleDAO roleDao;
    @Resource
    private RoleMenuDAO roleMenuDao;
    @Resource
    private UserRoleDAO userRoleDao;
    @Resource
    private RolePrivilegeDAO rolePrivilegeDao;
    @Resource
    private UserDAO userDao;
    @Resource
    private PrivilegeDAO privilegeDao;
    @Resource
    private MenuDAO menuDao;

    @Override
    public CommRoleModel queryById(Integer id) {
        if(id == null){
            throw new RuntimeException("角色id不能为空！");
        }
        return roleDao.selectById(id);
    }

    @Override
    public List<CommRoleModel> queryByParams(RoleVo param) {
        if(param == null){
            throw new RuntimeException("查询条件对象不存在！");
        }
//        int total = roleDao.selectCountByParams(param);
        // // TODO: 2016-08-01
//        param.setTotalRecord(total);
        return roleDao.selectByParams(param);
    }

    @Override
    public int add(CommRoleModel commRoleModel) {
        if(commRoleModel == null){
            throw new RuntimeException("角色对象为空！");
        }
        return roleDao.insert(commRoleModel);
    }

    @Override
    public int addBatch(List<CommRoleModel> roleList) {
        if(!CollectionUtils.isEmpty(roleList)){
            return roleDao.insertBatch(roleList);
        }
        return 0;
    }

    @Override
    public int modify(CommRoleModel commRoleModel) {
        if(commRoleModel == null){
            throw new RuntimeException("角色对象为空！");
        }
        manageRelation(commRoleModel);

        return roleDao.update(commRoleModel);
    }

    /**
     * 处理角色中间表的记录
     *
     * @param commRoleModel 角色对象
     */
    private void manageRelation(CommRoleModel commRoleModel) {
        Integer roleId = commRoleModel.getId();
        List<CommMenuModel> menuList = commRoleModel.getMenuList();
        List<CommPrivilegesModel> privList = commRoleModel.getPrivilegeList();
        List<CommLoginModel> userList = commRoleModel.getLoginUserList();
        if(!CollectionUtils.isEmpty(menuList)){
//            int menuCount = menuDao.countByMenuList(menuList);
//            if(menuCount != menuList.size()){
//                throw new BaseException("角色关联的菜单状态发生变化，请刷新页面！");
//            }
            roleMenuDao.deleteByRoleId(roleId);
            roleMenuDao.insertMenusWithRoleId(commRoleModel.getMenuList(), roleId);
        }

        if(!CollectionUtils.isEmpty(privList)){
//            int privCount = privilegeDao.countByPrivList(privList);
//            if(privCount != privList.size()){
//                throw new BaseException("角色关联的权限状态发生变化，请刷新页面！");
//            }
            rolePrivilegeDao.deleteByRoleId(roleId);
            rolePrivilegeDao.insertPrivsWithRoleId(commRoleModel.getPrivilegeList(), roleId);
        }

        if(!CollectionUtils.isEmpty(userList)){
            int userCount = userDao.countByUserList(userList);
            if(userCount != userList.size()){
                throw new BaseException("角色关联的用户状态发生变化， 请刷新页面！");
            }
            userRoleDao.deleteByRoleId(roleId);
            userRoleDao.insertUsersWithRoleId(commRoleModel.getLoginUserList(), roleId);
        }
    }

    @Override
    public int remove(Integer id) {
        if(id == null){
            throw new RuntimeException("角色id不能为空！");
        }

        int userCount = userRoleDao.countUsersByRoleId(id);
        if(userCount != 0){
            throw new RuntimeException("该角色已与用户绑定！");
        }
        return roleDao.deleteById(id);
    }

    @Override
    public int removeBatch(String ids) {
        if(!StringUtils.isEmpty(ids)){
            List<String> idList = Arrays.asList(ids.split(","));
            int rows = 0;
            for(String idStr : idList){
                Integer id = Integer.parseInt(idStr);
                rows += remove(id);
            }
            return rows;
        }
        return 0;
    }

    @Override
    public void savePrivilegesRole(Integer roleId) {

    }

    @Override
    public void removeAllUserRelByRoleId(Integer roleId) {
        if(roleId != null){
            userRoleDao.deleteByRoleId(roleId);
        }
    }

    @Override
    public void removeAllPrivilegeRelByRoleId(Integer roleId) {
        if(roleId != null){
            rolePrivilegeDao.deleteByRoleId(roleId);
        }
    }

    @Override
    public List<CommRoleModel> queryAllRolesByUserId(Integer userId) {
        return roleDao.selectRolesByUserId(userId);
    }
}
