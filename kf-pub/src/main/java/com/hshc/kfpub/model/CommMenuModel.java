package com.hshc.kfpub.model;

import java.util.List;

import com.hshc.kfpub.base.BaseModel;

/**
 * 菜单表实体类
 * 
 * @author TODO(这里写自己的中文名字)
 * @date 2016-07-30
 */
public class CommMenuModel extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1698258449574700044L;
    private CommMenuModel parentMenu;
    private List<CommMenuModel> subMenuList;
    // 菜单类型，0菜单组，1菜单
    private String menuType;
    // 菜单名称
    private String menuName;
    // 菜单URL
    private String menuUrl;
    // 菜单图标路径
    private String menuIcon;
    // 关联角色列表
    private List<CommRoleModel> roleList;

    public CommMenuModel getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(CommMenuModel parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<CommMenuModel> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<CommMenuModel> subMenuList) {
        this.subMenuList = subMenuList;
    }

    /**
     * @return menuType String
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * @param menuType the menuType to set
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    /**
     * @return menuName String
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * @return menuUrl String
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * @param menuUrl the menuUrl to set
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * @return menuIcon String
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * @param menuIcon the menuIcon to set
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public List<CommRoleModel> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<CommRoleModel> roleList) {
        this.roleList = roleList;
    }
}
