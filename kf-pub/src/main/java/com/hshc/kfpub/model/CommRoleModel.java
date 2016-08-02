package com.hshc.kfpub.model;

import java.util.Date;
import java.util.List;

import com.hshc.kfpub.base.BaseModel;

/**
 * 角色表实体类
 * 
 * @author TODO(这里写自己的中文名字)
 * @date 2016-07-30
 */
public class CommRoleModel extends BaseModel {
    /**
     * 
     */
    private static final long serialVersionUID = 6084572966508997070L;
    // 角色编码
    private String roleCode;
    // 角色名称
    private String roleName;
    // 角色描述
    private String roleDesc;
    // 创建日期
    private Date createDate;
    // 创建人
    private CommLoginModel creator;
    // 最后更新日期
    private Date lastUpdateDate;
    // 最后更新人
    private CommLoginModel lastUpdater;
    // 是否删除：0未删除，1已删除
    private Boolean isDel;
    // 关联用户集合
    private List<CommLoginModel> loginUserList;
    // 关联菜单集合
    private List<CommMenuModel> menuList;
    // 关联权限集和
    private List<CommPrivilegesModel> privilegeList;

    /**
     * @return roleCode String
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * @return roleName String
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * @return roleDesc String
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc the roleDesc to set
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    /**
     * @return createDate Date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return lastUpdateDate Date
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * @return isDel Boolean
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * @param isDel the isDel to set
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public CommLoginModel getCreator() {
        return creator;
    }

    public void setCreator(CommLoginModel creator) {
        this.creator = creator;
    }

    public CommLoginModel getLastUpdater() {
        return lastUpdater;
    }

    public void setLastUpdater(CommLoginModel lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    public List<CommLoginModel> getLoginUserList() {
        return loginUserList;
    }

    public void setLoginUserList(List<CommLoginModel> loginUserList) {
        this.loginUserList = loginUserList;
    }

    public List<CommMenuModel> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<CommMenuModel> menuList) {
        this.menuList = menuList;
    }

    public List<CommPrivilegesModel> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<CommPrivilegesModel> privilegeList) {
        this.privilegeList = privilegeList;
    }
}
