package com.blog.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回model
 */
public class ResultModel {
    public static final int SUCCESS = 0;
    public static final int UNKNOWN_ERROR = -1001;
    public static final int USER_NOT_EXIST_ERROR = -1002;
    public static final int SERVICE_EXCEPTION_ERROR = -1003;
    public static final int WRONG_PARAMS_ERROR = -1004;
    public static final int OP_FAILED_ERROR = -1005;
    public static final int SERVER_INTERNAL_EXCEPTION = -1006;

    /*登陆*/
    public static final int CODE_VALIDATE_ERROR = -1101;
    public static final int LOGIN_EXPIRE = -1102;
    public static final int PHONE_NOT_REGISTER = -1103;
    public static final int CODE_ERROR = -1104;
    public static final int VERIFY_OVERTIME = -1105;


    private static Map<Integer, String> codeMap = new HashMap<>();

    static {
        codeMap.put(SUCCESS, "成功");
        codeMap.put(UNKNOWN_ERROR, "未知错误");
        codeMap.put(USER_NOT_EXIST_ERROR, "用户不存在");
        codeMap.put(SERVICE_EXCEPTION_ERROR, "服务异常");
        codeMap.put(WRONG_PARAMS_ERROR, "参数设置错误");
        codeMap.put(OP_FAILED_ERROR, "操作失败");

        codeMap.put(CODE_VALIDATE_ERROR, "校验失败");
        codeMap.put(LOGIN_EXPIRE, "登录已过期，请重新登录");
        codeMap.put(PHONE_NOT_REGISTER, "手机号未注册");
        codeMap.put(CODE_ERROR, "验证码输入错误");
        codeMap.put(VERIFY_OVERTIME, "验证码已过期");

    }

    private String message;
    private Integer code;
    private Object data;

    public ResultModel(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public ResultModel(String message, Integer code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }


    public static ResultModel success() {
        return new ResultModel(SUCCESS, "成功");
    }

    public static ResultModel success(Object data) {
        return new ResultModel("成功", SUCCESS, data);
    }

    public static ResultModel error() {
        return new ResultModel(-1001, "未知错误");
    }


    public static ResultModel error(Integer code) {
        String errorMessage = codeMap.get(code);
        if (errorMessage == null) {
            errorMessage = codeMap.get(UNKNOWN_ERROR);
        }
        return new ResultModel(code, errorMessage);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
