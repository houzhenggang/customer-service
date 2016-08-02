package com.hshc.kfpub.vo;

import com.hshc.kfpub.base.BaseVO;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-01 14:32
 */
public class DeptVo extends BaseVO {

    // 部门编码
    private String code;
    // 部门名称
    private String name;
    // 部门别名
    private String alias;
    // 部门描述
    private String description;
    // 是否删除：0未删除，1已删除
    private Boolean isDel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }
}
