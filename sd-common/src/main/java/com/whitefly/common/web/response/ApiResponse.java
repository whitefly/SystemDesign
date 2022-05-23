package com.whitefly.common.web.response;

public class ApiResponse<T> extends BaseResponse {

    T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
