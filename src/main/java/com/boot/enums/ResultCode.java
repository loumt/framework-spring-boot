package com.boot.enums;

public enum ResultCode {

    SUCCESS("000000", "通用成功代码"),
    FAILUE("000001", "通用失败代码"),
    UNDEFINED_ERROR("000002", "未定义的，不可预知的其他异常"),
    INVALIDATE_PARAMETER("000003", "参数缺失或无效"),
    ALREADY_EXIST("000004", "已经存在"),
    USER_INFO_ERROR("000005", "用户信息错误"),
    SERVICE_ERROR("000006","服务器错误");

    private String code;

    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
