package com.hshc.kfpub.model;

import java.util.Date;
import java.util.List;

import com.hshc.kfpub.base.BaseModel;

/**
 * 用户部门表实体类
 * 
 * @author TODO(这里写自己的中文名字)
 * @date 2016-07-30
 */
public class CommDeptModel extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = 5017507232098163198L;
    // 父机构
    private CommDeptModel parentDept;
    // 子机构列表
    private List<CommDeptModel> subDeptList;
    // 部门编码
    private String code;
    // 部门名称
    private String name;
    // 部门别名
    private String alias;
    // 部门描述
    private String description;
    // 创建时间
    private Date createTime;
    // 创建人
    private CommLoginModel creator;
    // 最后更新日期
    private Date lastUpdateTime;
    // 最后更新人
    private CommLoginModel lastUpdater;
    // 是否删除：0未删除，1已删除
    private Boolean isDel;
    // 拥有用户列表
    private List<CommLoginModel> loginUserList;

    /**
     * @return code String
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return alias String
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return createTime Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return lastUpdateTime Date
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdateTime the lastUpdateTime to set
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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

    public CommDeptModel getParentDept() {
        return parentDept;
    }

    public void setParentDept(CommDeptModel parentDept) {
        this.parentDept = parentDept;
    }

    public List<CommDeptModel> getSubDeptList() {
        return subDeptList;
    }

    public void setSubDeptList(List<CommDeptModel> subDeptList) {
        this.subDeptList = subDeptList;
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

}
