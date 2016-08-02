package com.hshc.kfcontroller.controller.base.comm;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面跳转
 * 
 * @className PageSkipController
 * @author 范玉唯
 * @version 2016-7-30 13:19:32
 */
@Controller
@Scope("prototype")
@RequestMapping("/")
public class PageSkipController {
	/**
	 * 进登录
	 * 
	 * @author 范玉唯
	 */
	@RequestMapping("index")
	public ModelAndView index() {
		return new ModelAndView("mainFrame");
	}

	/**
	 * 跳转到用户管理页面
	 * 
	 * @author 范玉唯
	 */
	@RequestMapping("UserManagerPage")
	public ModelAndView UserManagerPage() {
		return new ModelAndView("userManager");
	}

}
