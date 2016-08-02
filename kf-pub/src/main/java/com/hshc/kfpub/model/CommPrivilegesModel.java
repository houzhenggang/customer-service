package com.hshc.kfpub.model;

import java.util.List;

import com.hshc.kfpub.base.BaseModel;

/**
 * 权限表实体类
 * 
 * @author TODO(这里写自己的中文名字)
 * @date 2016-07-30
 */
public class CommPrivilegesModel extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = 7102369079312974744L;
    // 父权限
    private CommPrivilegesModel parentPriv;
    // 子权限集合
    private List<CommPrivilegesModel> subPrivList;
    // 权限编码
    private String privCode;
    // 权限类型：0操作权限，1数据权限
    private String privType;
    // 位置路径，格式：主菜单-子菜单-页面
    private String privPath;
    // 关联用户集合
    private List<CommLoginModel> loginUserList;
    // 关联角色集合
    private List<CommRoleModel> roleList;

    public CommPrivilegesModel getParentPriv() {
        return parentPriv;
    }

    public void setParentPriv(CommPrivilegesModel parentPriv) {
        this.parentPriv = parentPriv;
    }

    public List<CommPrivilegesModel> getSubPrivList() {
        return subPrivList;
    }

    public void setSubPrivList(List<CommPrivilegesModel> subPrivList) {
        this.subPrivList = subPrivList;
    }

    /**
     * @return privCode String
     */
    public String getPrivCode() {
        return privCode;
    }

    /**
     * @param privCode the privCode to set
     */
    public void setPrivCode(String privCode) {
        this.privCode = privCode == null ? null : privCode.trim();
    }

    /**
     * @return privType String
     */
    public String getPrivType() {
        return privType;
    }

    /**
     * @param privType the privType to set
     */
    public void setPrivType(String privType) {
        this.privType = privType == null ? null : privType.trim();
    }

    /**
     * @return privPath String
     */
    public String getPrivPath() {
        return privPath;
    }

    /**
     * @param privPath the privPath to set
     */
    public void setPrivPath(String privPath) {
        this.privPath = privPath == null ? null : privPath.trim();
    }

    public List<CommRoleModel> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<CommRoleModel> roleList) {
        this.roleList = roleList;
    }

    public List<CommLoginModel> getLoginUserList() {
        return loginUserList;
    }

    public void setLoginUserList(List<CommLoginModel> loginUserList) {
        this.loginUserList = loginUserList;
    }
    
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof CommPrivilegesModel) {
        	CommPrivilegesModel cllm = (CommPrivilegesModel) anObject;
            if (privCode.equals(cllm.getPrivCode())) {
                return true;
            }
        }
        return false;
    }
}
