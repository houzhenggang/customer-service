package com.hshc.kfpub.vo;

import com.hshc.kfpub.base.BaseVO;
import com.hshc.kfpub.model.CommLoginModel;

import java.util.Date;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-01 14:35
 */
public class RoleVo extends BaseVO {

    // 角色编码
    private String roleCode;
    // 角色名称
    private String roleName;
    // 角色描述
    private String roleDesc;
    // 是否删除：0未删除，1已删除
    private Boolean isDel;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }
}
