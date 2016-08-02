package com.hshc.kfcontroller.controller.base.user;

import com.hshc.kfcontroller.controller.base.comm.BaseController;
import com.hshc.kfcontroller.controller.base.comm.JsonResult;
import com.hshc.kfpub.comm.DatagridObject;
import com.hshc.kfpub.exception.BaseException;
import com.hshc.kfpub.model.CommMenuModel;
import com.hshc.kfpub.model.CommRoleModel;
import com.hshc.kfpub.vo.RoleVo;
import com.hshc.kfservice.service.usermgr.MenuMgrService;
import com.hshc.kfservice.service.usermgr.PrivilegeMgrService;
import com.hshc.kfservice.service.usermgr.RoleMgrService;
import com.hshc.kfservice.service.usermgr.UserMgrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-07-31 16:33
 */
@Controller
public class RoleController extends BaseController{

    @Resource
    private RoleMgrService roleMgrService;
    @Resource
    private PrivilegeMgrService privilegeMgrService;
    @Resource
    private UserMgrService userMgrService;
    @Resource
    private MenuMgrService menuMgrService;

    @RequestMapping(value = "/rolesPage", method = RequestMethod.GET)
    public String toRolePage(){
        return "user/role";
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    @ResponseBody
    public DatagridObject getRoles(RoleVo roleVo){
        List<CommRoleModel> roleList = roleMgrService.queryByParams(roleVo);
//        result.put("total", commRoleModel.getTotalRecord());
//        int total = roleVo.getTotalRecord();
        return new DatagridObject<>(10, roleList);
    }

    @RequestMapping(value = "/role/{id}/privileges", method = RequestMethod.GET)
    @ResponseBody
    public String getPrivilegesByRoleId(@PathVariable("id") String idStr){
        try{
            Integer roleId = Integer.parseInt(idStr);
            return toJSON(JsonResult.success(privilegeMgrService.queryPrivilegesWithRoleFlag(roleId)));
        }catch (NumberFormatException e){
            throw new BaseException("非法的角色id");
        }
    }

    @RequestMapping(value = "/role/{id}/users", method = RequestMethod.GET)
    @ResponseBody
    public String getUsersByRoleId(@PathVariable("id") String idStr){
        try{
            Integer roleId = Integer.parseInt(idStr);
            return toJSON(JsonResult.success(userMgrService.queryUsersWithRoleFlag(roleId)));
        }catch (NumberFormatException e){
            throw new BaseException("非法的角色id");
        }
    }

    @RequestMapping(value = "/role/{id}/menus", method = RequestMethod.GET)
    @ResponseBody
    public String getMenusByRoleId(@PathVariable("id") String idStr){
        try{
            Integer roleId = Integer.parseInt(idStr);
            return toJSON(JsonResult.success(menuMgrService.queryMenusWithRoleFlag(roleId)));
        }catch (NumberFormatException e){
            throw new BaseException("非法的角色id");
        }
    }
}
