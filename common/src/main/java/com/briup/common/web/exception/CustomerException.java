package com.briup.common.web.exception;

import com.briup.common.web.response.ResultCode;
import lombok.Data;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/1/2022-11-01-5:23 PM
 * @Description：com.briup.common.web.exception
 */
@Data
public class CustomerException extends RuntimeException{
    private String message;
    private ResultCode resultCode; // 抛出的枚举对象
    public CustomerException(String message){
        super(message);
        this.message = message;
    }
    // throw new CustomerException(ResultCode.PARAM_IS_BLANK);
    public CustomerException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
}