package com.hshc.kfpub.model;

import java.util.Date;
import java.util.List;

import com.hshc.kfpub.base.BaseModel;

/**
 * 用户登录表实体类
 * 
 * @author TODO(这里写自己的中文名字)
 * @date 2016-07-30
 */
public class CommLoginModel extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = -8919084728165715205L;
    // 登录名
    private String loginName;
    // 登录密码
    private String loginPwd;
    // 启用状态，0停用，1启用，2冻结
    private Byte status;
    // 有效期开始日期
    private Date validStartDate;
    // 有效期结束日期
    private Date validEndDate;
    // 是否删除：0未删除，1已删除
    private Boolean isDel;
    // 所属部分列表
    private List<CommDeptModel> deptList;
    // 关联角色集合
    private List<CommRoleModel> roleList;
    // 关联日志集合
    private List<CommLoginLogModel> loginLogList;
    // 关联权限集合
    private List<CommPrivilegesModel> privilegeList;

    /**
     * @return loginName String
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * @return loginPwd String
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * @param loginPwd the loginPwd to set
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     * @return status Byte
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return validStartDate Date
     */
    public Date getValidStartDate() {
        return validStartDate;
    }

    /**
     * @param validStartDate the validStartDate to set
     */
    public void setValidStartDate(Date validStartDate) {
        this.validStartDate = validStartDate;
    }

    /**
     * @return validEndDate Date
     */
    public Date getValidEndDate() {
        return validEndDate;
    }

    /**
     * @param validEndDate the validEndDate to set
     */
    public void setValidEndDate(Date validEndDate) {
        this.validEndDate = validEndDate;
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

    public List<CommDeptModel> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<CommDeptModel> deptList) {
        this.deptList = deptList;
    }

    public List<CommRoleModel> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<CommRoleModel> roleList) {
        this.roleList = roleList;
    }

    public List<CommLoginLogModel> getLoginLogList() {
        return loginLogList;
    }

    public void setLoginLogList(List<CommLoginLogModel> loginLogList) {
        this.loginLogList = loginLogList;
    }

    public List<CommPrivilegesModel> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<CommPrivilegesModel> privilegeList) {
        this.privilegeList = privilegeList;
    }
}
