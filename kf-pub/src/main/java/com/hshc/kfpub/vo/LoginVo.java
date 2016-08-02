package com.hshc.kfpub.vo;

import com.hshc.kfpub.base.BaseVO;

import java.util.Date;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-01 14:34
 */
public class LoginVo extends BaseVO {

    // 登录名
    private String loginName;
    // 登录密码
    private String loginPwd;
    // 启用状态，0停用，1启用，2冻结
    private Byte status;
    // 有效期开始日期起始
    private Date validStartDateFrom;
    // 有效期开始日期截止
    private Date validStartDateTo;
    // 有效期结束日期起始
    private Date validEndDateFrom;
    // 有效期结束日期截止
    private Date validEndDateTo;
    // 是否删除：0未删除，1已删除
    private Boolean isDel;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getValidStartDateFrom() {
        return validStartDateFrom;
    }

    public void setValidStartDateFrom(Date validStartDateFrom) {
        this.validStartDateFrom = validStartDateFrom;
    }

    public Date getValidStartDateTo() {
        return validStartDateTo;
    }

    public void setValidStartDateTo(Date validStartDateTo) {
        this.validStartDateTo = validStartDateTo;
    }

    public Date getValidEndDateFrom() {
        return validEndDateFrom;
    }

    public void setValidEndDateFrom(Date validEndDateFrom) {
        this.validEndDateFrom = validEndDateFrom;
    }

    public Date getValidEndDateTo() {
        return validEndDateTo;
    }

    public void setValidEndDateTo(Date validEndDateTo) {
        this.validEndDateTo = validEndDateTo;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }
}
