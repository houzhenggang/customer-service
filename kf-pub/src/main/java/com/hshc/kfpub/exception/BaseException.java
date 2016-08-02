package com.hshc.kfpub.exception;

import java.util.Map;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-02 09:26
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -1624206726332133105L;
    private String code;
    private String message;
    private Map<String, Object> attrs;

    public BaseException(String message){
        this(null, message, null);
    }

    public BaseException(String code, String message) {
        this(code, message, null);
    }

    public BaseException(String code, String message, Map<String, Object> attrs) {
        this.code = code;
        this.message = message;
        this.attrs = attrs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
    }
}
