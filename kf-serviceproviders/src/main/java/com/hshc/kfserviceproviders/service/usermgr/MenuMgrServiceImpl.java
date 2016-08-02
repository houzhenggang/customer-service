package com.hshc.kfserviceproviders.service.usermgr;

import com.hshc.kfdao.dao.usermgr.MenuDAO;
import com.hshc.kfpub.model.CommMenuModel;
import com.hshc.kfpub.vo.MenuVo;
import com.hshc.kfservice.service.usermgr.MenuMgrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单业务逻辑
 *
 * @author 钟林俊
 * @version V1.0 2016-07-30 15:26
 */
@Service
public class MenuMgrServiceImpl implements MenuMgrService {

    @Resource
    private MenuDAO menuDao;

    @Override
    public List<CommMenuModel> queryAllMenus() {
        List<CommMenuModel> rawMenuList = menuDao.selectAll();
        return getTreeMenuList(rawMenuList);
    }

    /**
     * 将平行菜单结构转换为树形
     *
     * @param rawMenuList 菜单集合（平行结构）
     * @return 树形菜单集合
     */
    private List<CommMenuModel> getTreeMenuList(List<CommMenuModel> rawMenuList) {
        List<CommMenuModel> treeMenuList = new ArrayList<>();
        for(CommMenuModel parentMenu : rawMenuList){
            if(parentMenu.getParentMenu() == null) {
                treeMenuList.add(parentMenu);
                setSubMenuList(parentMenu, rawMenuList);
            }
        }
        return treeMenuList;
    }

    /**
     * 设置父菜单的子菜单列表
     *
     * @param parentMenu 父菜单对象
     * @param rawMenuList 原始菜单集合（平行结构）
     */
    private void setSubMenuList(CommMenuModel parentMenu, List<CommMenuModel> rawMenuList) {
        List<CommMenuModel> subMenuList = new ArrayList<>();
        Integer parentId = parentMenu.getId();
        for(CommMenuModel subMenu : rawMenuList){
            if(subMenu.getParentMenu() != null && subMenu.getParentMenu().getId().equals(parentId)){
                subMenuList.add(subMenu);
            }
        }
        if (!subMenuList.isEmpty()) {
            parentMenu.setSubMenuList(subMenuList);
            for (CommMenuModel subMenu : subMenuList) {
                setSubMenuList(subMenu, rawMenuList);
            }
        }
    }

    @Override
    public List<CommMenuModel> queryAllMenusWithUserFlag(Integer userId) {
        if(userId == null){
            throw new RuntimeException("用户id不能为空！");
        }
        return menuDao.selectWithUserFlag(userId);
    }

    @Override
    public List<CommMenuModel> queryUserMenus(Integer userId) {
        if(userId == null){
            throw new RuntimeException("用户id不能为空！");
        }
        return menuDao.selectByUserId(userId);
    }

    @Override
    public List<CommMenuModel> queryMenusByRoleId(Integer roleId) {
        if(roleId == null){
            throw new RuntimeException("角色id不能为空！");
        }
        return getTreeMenuList(menuDao.selectByRoleId(roleId));
    }

    @Override
    public List<CommMenuModel> queryMenusWithRoleFlag(Integer roleId) {
        if(roleId == null){
            throw new RuntimeException("角色id不能为空！");
        }
        return getTreeMenuList(menuDao.selectWithRoleFlag(roleId));
    }

    @Override
    public CommMenuModel queryById(Integer id) {
        return null;
    }

    @Override
    public List<CommMenuModel> queryByParams(MenuVo param) {
        return null;
    }

    @Override
    public int add(CommMenuModel commMenuModel) {
        return 0;
    }

    @Override
    public int addBatch(List<CommMenuModel> list) {
        return 0;
    }

    @Override
    public int modify(CommMenuModel commMenuModel) {
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
