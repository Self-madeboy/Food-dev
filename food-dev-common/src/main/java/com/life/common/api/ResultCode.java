package com.life.common.api;

/**
 * @author
 */

public enum ResultCode implements IErrorCode {

     //成功
    SUCCESS(200,"成功"),

    //失败
    FAIL(400,"失败"),

    // 未认证（签名错误）
    UNAUTHORIZED(403,"token invalid"),

    // 接口不存在
    NOT_FOUND(404,"接口不存在"),

    //需要刷新页面
    REFRESH_PAGE(406,"数据初始化错误"),

    PARAM_ERROR(407,"参数错误");

    private long code;

    private String message;

    private ResultCode(long code, String message){
        this.code = code;
        this.message = message;
    }


    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
