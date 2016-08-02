/**
 * 所有controller的公共父类
 * 
 * @title: BaseController.java
 * @author 邢治理
 * @date 2016年7月28日
 */
package com.hshc.kfcontroller.controller.base.comm;

import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.hshc.kfpub.comm.U;

/**
 * 所有controller的公共父类
 * 
 * @className BaseController
 * @author 邢治理
 * @version V1.0 2016年7月28日
 */
public abstract class BaseController {

    protected ModelAndView toPage(String viewName) {
        return new ModelAndView(viewName);
    }

    protected ModelAndView toPage(String viewName, Map<String, ?> model) {
        return new ModelAndView(viewName, model);
    }

    protected String toJSON(JsonResult ret) {
        return U.JSON.toJson(ret);
    }

    @ExceptionHandler
    public String globalExceptionHandler(HttpServletRequest request, Exception ex) {
        CharArrayWriter buff = new CharArrayWriter(1024);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(buff));
            ex.printStackTrace(pw);
            pw.flush();
            request.setAttribute("errDetailMsg", buff.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) pw.close();
            buff = null;
        }
        ex.printStackTrace();
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            request.setAttribute("errShortMsg", "{\"flag\":false,\"errMsg\":\"" + ex.getMessage() + "\"}");
            return "errorAjax";
        }
        request.setAttribute("errShortMsg", ex.getMessage());
        return "error";
    }


}
