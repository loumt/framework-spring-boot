package com.boot.utils;

import com.boot.enums.ResultCode;

public class ResultModel {

    private boolean isSuccess;
    private ResultCode resultCode;

    public ResultModel() { }

    public ResultModel(boolean isSuccess, ResultCode resultCode) {
        this.isSuccess = isSuccess;
        this.resultCode = resultCode;
    }

    public static ResultModel isCommonSuccess(){
        return new ResultModel(true, ResultCode.SUCCESS);
    }

}
