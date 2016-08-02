/**
 * 工具类
 * 
 * @title: PubUtil.java
 * @author 邢治理
 * @date 2016年7月30日
 */
package com.hshc.kfpub.comm;

import com.hshc.kfpub.model.CommLoginModel;

/**
 * 工具类
 * 
 * @className PubUtil
 * @author 邢治理
 * @version V1.0 2016年7月30日
 */
public final class PubUtil {

    private PubUtil() {
    }

    public static CommLoginModel getCurrentUser() {
        return new CommLoginModel();
    }

}
