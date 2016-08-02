/**
 * 所有Model的公共父接口
 * 
 * @title: BaseModel.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfpub.base;

/**
 * 所有Model的公共父接口
 * 
 * @className BaseModel
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public class BaseModel implements java.io.Serializable {

    // 主键
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
