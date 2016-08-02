package com.hshc.kfserviceproviders.service.usermgr;

import com.hshc.kfdao.dao.usermgr.PrivilegeDAO;
import com.hshc.kfpub.model.CommMenuModel;
import com.hshc.kfpub.model.CommPrivilegesModel;
import com.hshc.kfpub.vo.PrivilegeVo;
import com.hshc.kfservice.service.usermgr.PrivilegeMgrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限业务逻辑
 *
 * @author 钟林俊
 * @version V1.0 2016-07-30 15:26
 */
@Service
public class PrivilegeMgrServiceImpl implements PrivilegeMgrService {

    @Resource
    private PrivilegeDAO privilegeDao;

    @Override
    public List<CommPrivilegesModel> queryPrivilegesByRoleId(Integer roleId) {
        if(roleId == null){
            throw new RuntimeException("角色id为空！");
        }
        return getTreePrivList(privilegeDao.selectPrivilegesByRoleId(roleId));
    }

    /**
     * 将平行权限结构转换为树形
     *
     * @param rawPrivList 权限集合（平行结构）
     * @return 树形菜单集合
     */
    private List<CommPrivilegesModel> getTreePrivList(List<CommPrivilegesModel> rawPrivList) {
        List<CommPrivilegesModel> treePrivList = new ArrayList<>();
        for(CommPrivilegesModel parentPriv : rawPrivList){
            if(parentPriv.getParentPriv() == null) {
                treePrivList.add(parentPriv);
                setSubMenuList(parentPriv, rawPrivList);
            }
        }
        return treePrivList;
    }

    /**
     * 设置父权限的子权限列表
     *
     * @param parentPriv 父权限对象
     * @param rawPrivList 原始权限集合（平行结构）
     */
    private void setSubMenuList(CommPrivilegesModel parentPriv, List<CommPrivilegesModel> rawPrivList) {
        List<CommPrivilegesModel> subPrivList = new ArrayList<>();
        Integer parentId = parentPriv.getId();
        for(CommPrivilegesModel subPriv : rawPrivList){
            if(subPriv.getParentPriv() != null && subPriv.getParentPriv().getId().equals(parentId)){
                subPrivList.add(subPriv);
            }
        }
        if (!subPrivList.isEmpty()) {
            parentPriv.setSubPrivList(subPrivList);
            for (CommPrivilegesModel subPriv : subPrivList) {
                setSubMenuList(subPriv, rawPrivList);
            }
        }
    }

    @Override
    public void removeAllPrivilegeRelByRoleId(Integer rid) {

    }

    @Override
    public void savePrivilegesRole(Integer rid) {

    }

    @Override
    public List<CommPrivilegesModel> queryPrivilegesWithRoleFlag(Integer roleId) {
        if(roleId == null){
            throw new RuntimeException("角色id为空！");
        }
        return getTreePrivList(privilegeDao.selectPrivilegesWithRoleFlag(roleId));
    }

    @Override
    public CommPrivilegesModel queryById(Integer id) {
        return null;
    }


    @Override
    public List<CommPrivilegesModel> queryByParams(PrivilegeVo param) {
        return null;
    }

    @Override
    public int add(CommPrivilegesModel commPrivilegesModel) {
        return 0;
    }

    @Override
    public int addBatch(List<CommPrivilegesModel> list) {
        return 0;
    }

    @Override
    public int modify(CommPrivilegesModel commPrivilegesModel) {
        return 0;
    }

    @Override
    public int remove(Integer id) {
        return 0;
    }

    @Override
    public int removeBatch(String ids) {
        return 0;
    }
}
