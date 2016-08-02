/**
 * 用户管理Controller
 * 
 * @title: UserController.java
 * @author 耿长宝
 * @date 2016年7月31日14:18:16
 */
package com.hshc.kfcontroller.controller.base.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.hshc.kfpub.vo.LoginVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hshc.kfcontroller.controller.base.comm.BaseController;
import com.hshc.kfpub.model.CommLoginModel;
import com.hshc.kfservice.service.usermgr.UserMgrService;

/**
 * 登录Controller
 * 
 * @className UserController
 * @author 耿长宝
 * @version V1.0 2016年7月31日14:18:22
 */
@Controller
public class UserController extends BaseController {
	
	@Resource
	private UserMgrService userService; 

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUsers(LoginVo user) {
        Map<String, Object> result = new HashMap<>();
		userService.queryByParams(user);
        result.put("flag", true);
        result.put("rows", userService.queryByParams(user));
//        result.put("total", user.getTotalRecord());
        return result;
    }
}
