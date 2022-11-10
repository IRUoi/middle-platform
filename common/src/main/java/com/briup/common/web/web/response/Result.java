package com.briup.common.web.web.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/1/2022-11-01-4:05 PM
 * @Description：com.briup.common.web.response
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;

    private Result() {}

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    /**
     * 操作失败，自定义code和msg
     */
    public static Result failure(Integer code, String msg) {
        Result result = new Result(code,msg);
        return result;
    }

    /**
     * 操作成功，没有返回的数据
     */
    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS); // 1 s
        return result;
    }

    /**
     * 操作成功，有返回的数据
     */
    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    /**
     * 操作成功，有返回的数据
     */
    public static <T> Result<T> success(String message) {
        return new Result(ResultCode.SUCCESS.code(),message);
    }

    /**
     * 操作失败，没有返回的数据
     */
    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    /**
     * 操作失败，没有返回的数据
     */
    public static Result failure(String message) {
        return new Result(ResultCode.ERROR.code(),message);
    }

    /**
     * 操作失败，有返回的数据
     */
    public static <T> Result<T> failure(ResultCode resultCode, T data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

}
