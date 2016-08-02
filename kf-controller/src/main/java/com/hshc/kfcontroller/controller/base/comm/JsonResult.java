package com.hshc.kfcontroller.controller.base.comm;

import com.hshc.kfpub.comm.U;

/**
 * JsonResult类返回数据对象
 * 
 * @className JsonResult
 * @author 邢治理
 * @version V1.0 2016年3月16日10:05:18
 */
public class JsonResult {

    /**
     * 消息状态
     */
    private boolean flag;
    /**
     * 消息内容
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public JsonResult(boolean flag, String msg, Object data){
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(boolean flag) {
        this(flag, "", "");
    }

    public static JsonResult success(Object data){
        return new JsonResult(true, "", data);
    }

    public static JsonResult fail(String msg){
        return new JsonResult(false, msg, "");
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setErrMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return U.JSON.toJson(this);
    }
}
