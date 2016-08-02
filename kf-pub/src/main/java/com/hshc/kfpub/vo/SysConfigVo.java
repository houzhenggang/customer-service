package com.hshc.kfpub.vo;

import com.hshc.kfpub.base.BaseVO;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-01 14:35
 */
public class SysConfigVo extends BaseVO {
    // 键类型，下划线、字母任选
    private String keyType;
    // 键类型名
    private String keyTypeName;
    // 键码，下划线、字母任选
    private String keyCode;
    // 键名称
    private String keyName;
    // 键值
    private String keyValue;
    // 备注
    private String keyRemark;
    // 状态，0未启用，1启用
    private String status;
    // 是否只读，0可写，1只读
    private String readonly;

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getKeyTypeName() {
        return keyTypeName;
    }

    public void setKeyTypeName(String keyTypeName) {
        this.keyTypeName = keyTypeName;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyRemark() {
        return keyRemark;
    }

    public void setKeyRemark(String keyRemark) {
        this.keyRemark = keyRemark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }
}
