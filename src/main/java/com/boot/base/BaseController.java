package com.boot.base;

import com.boot.enums.ResultCode;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String DATA = "data";


    protected Map<String, Object> isBackMap(ResultCode resultCode) {
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put(CODE, resultCode.getCode());
        rs.put(MSG, resultCode.getMsg());
        return rs;
    }

    protected Map<String, Object> isCommonSuccess() {
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put(CODE, ResultCode.SUCCESS.getCode());
        rs.put(MSG, ResultCode.SUCCESS.getMsg());
        return rs;
    }

    protected Map<String, Object> isCommonSuccess(Object Object) {
        Map<String, Object> rs = this.isCommonSuccess();
        rs.put(DATA, Object);
        return rs;
    }

}
