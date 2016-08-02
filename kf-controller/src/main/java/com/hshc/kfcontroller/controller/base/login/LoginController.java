/**
 * 登录Controller
 * 
 * @title: LoginController.java
 * @author 邢治理
 * @date 2016年7月30日
 */
package com.hshc.kfcontroller.controller.base.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hshc.kfcontroller.controller.base.comm.BaseController;

/**
 * 登录Controller
 * 
 * @className LoginController
 * @author 邢治理
 * @version V1.0 2016年7月30日
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

    public ModelAndView login() {
        return this.toPage("mainFrame");
    }
}
