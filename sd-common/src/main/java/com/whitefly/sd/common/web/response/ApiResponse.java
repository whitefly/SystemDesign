package com.whitefly.sd.common.web.response;

public class ApiResponse<T> extends BaseResponse {

    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
