package com.hshc.kfpub.model;

import com.hshc.kfpub.base.BaseModel;

/**
 * 系统配置表，不得用于业务码表实体类
 * 
 * @author TODO(这里写自己的中文名字)
 * @date 2016-07-30
 */
public class SysConfigModel extends BaseModel {
    /**
     * 
     */
    private static final long serialVersionUID = -2778820669885156566L;
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

    /**
     * @return keyType String
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     * @param keyType the keyType to set
     */
    public void setKeyType(String keyType) {
        this.keyType = keyType == null ? null : keyType.trim();
    }

    /**
     * @return keyTypeName String
     */
    public String getKeyTypeName() {
        return keyTypeName;
    }

    /**
     * @param keyTypeName the keyTypeName to set
     */
    public void setKeyTypeName(String keyTypeName) {
        this.keyTypeName = keyTypeName == null ? null : keyTypeName.trim();
    }

    /**
     * @return keyCode String
     */
    public String getKeyCode() {
        return keyCode;
    }

    /**
     * @param keyCode the keyCode to set
     */
    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode == null ? null : keyCode.trim();
    }

    /**
     * @return keyName String
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * @param keyName the keyName to set
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    /**
     * @return keyValue String
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * @param keyValue the keyValue to set
     */
    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue == null ? null : keyValue.trim();
    }

    /**
     * @return keyRemark String
     */
    public String getKeyRemark() {
        return keyRemark;
    }

    /**
     * @param keyRemark the keyRemark to set
     */
    public void setKeyRemark(String keyRemark) {
        this.keyRemark = keyRemark == null ? null : keyRemark.trim();
    }

    /**
     * @return status String
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return readonly String
     */
    public String getReadonly() {
        return readonly;
    }

    /**
     * @param readonly the readonly to set
     */
    public void setReadonly(String readonly) {
        this.readonly = readonly == null ? null : readonly.trim();
    }

}
