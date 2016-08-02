package com.hshc.kfpub.vo;

import com.hshc.kfpub.base.BaseVO;

import java.util.Date;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-01 14:33
 */
public class LoginLogVo extends BaseVO {

    // 登录类型：0本系统登录
    private String loginType;
    // 登录IP
    private String loginIp;
    // 登录时间起始
    private Date loginTimeFrom;
    // 登录时间截止
    private Date loginTimeTo;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTimeFrom() {
        return loginTimeFrom;
    }

    public void setLoginTimeFrom(Date loginTimeFrom) {
        this.loginTimeFrom = loginTimeFrom;
    }

    public Date getLoginTimeTo() {
        return loginTimeTo;
    }

    public void setLoginTimeTo(Date loginTimeTo) {
        this.loginTimeTo = loginTimeTo;
    }
}
