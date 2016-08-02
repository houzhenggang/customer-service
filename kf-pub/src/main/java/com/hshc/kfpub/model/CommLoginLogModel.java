package com.hshc.kfpub.model;

import java.util.Date;

import com.hshc.kfpub.base.BaseModel;

/**
 * 登录日志表实体类
 * 
 * @author TODO(这里写自己的中文名字)
 * @date 2016-07-30
 */
public class CommLoginLogModel extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = -749089081738759595L;
    // 登录类型：0本系统登录
    private String loginType;
    // 登录IP
    private String loginIp;
    // 登录时间
    private Date loginTime;
    // 登录人
    private CommLoginModel loginUser;

    /**
     * @return loginType String
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * @param loginType the loginType to set
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    /**
     * @return loginIp String
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp the loginIp to set
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * @return loginTime Date
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime the loginTime to set
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public CommLoginModel getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(CommLoginModel loginUser) {
        this.loginUser = loginUser;
    }
}
