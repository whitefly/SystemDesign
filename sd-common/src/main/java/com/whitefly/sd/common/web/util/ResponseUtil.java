package com.whitefly.sd.common.web.util;

import com.whitefly.sd.common.web.response.ApiResponse;

public class ResponseUtil {

    public static <T> ApiResponse<T> packSuccess(T t) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(t);
        response.setCode(0);
        response.setSuccess(Boolean.TRUE);
        return response;
    }

    public static <T> ApiResponse<T> packSuccess() {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(0);
        response.setSuccess(Boolean.TRUE);
        return response;
    }

    public static <T> ApiResponse<T> packFail(String errMsg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(-1);
        response.setErrMsg(errMsg);
        response.setSuccess(Boolean.FALSE);
        return response;
    }

    public static <T> ApiResponse<T> packFail(String errMsg, Integer code) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setErrMsg(errMsg);
        response.setSuccess(Boolean.FALSE);
        return response;
    }


}
