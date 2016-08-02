/**
 * 登录日志DAO
 * 
 * @title: LoginLogDAO.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfdao.dao.usermgr;

import com.hshc.kfdao.dao.base.BaseDAO;
import com.hshc.kfpub.model.CommLoginLogModel;
import com.hshc.kfpub.vo.LoginLogVo;
import org.springframework.stereotype.Repository;

/**
 * 登录日志DAO
 * 
 * @className LoginLogDAO
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface LoginLogDAO extends BaseDAO<LoginLogVo, CommLoginLogModel> {

}
