package com.hshc.kfpub.vo;

import com.hshc.kfpub.base.BaseVO;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-01 14:34
 */
public class PrivilegeVo extends BaseVO {

    // 权限编码
    private String privCode;
    // 权限类型：0操作权限，1数据权限
    private String privType;
    // 位置路径，格式：主菜单-子菜单-页面
    private String privPath;

    public String getPrivCode() {
        return privCode;
    }

    public void setPrivCode(String privCode) {
        this.privCode = privCode;
    }

    public String getPrivType() {
        return privType;
    }

    public void setPrivType(String privType) {
        this.privType = privType;
    }

    public String getPrivPath() {
        return privPath;
    }

    public void setPrivPath(String privPath) {
        this.privPath = privPath;
    }
}
