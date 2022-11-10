package com.briup.common.web.web.exception;

import com.briup.common.web.web.response.Result;
import com.briup.common.web.web.response.ResultCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Auther: ZHU(lc))
 * @Date: 11/1/2022-11-01-5:21 PM
 * @Description：com.briup.common.web.exception
 */
//@ControllerAdvice 页面
@RestControllerAdvice // @RestController + @Advice
public class GlobalExceptionHandler {
    /**
     * 所有异常都会被捕获 返回统一格式
     *
     * @param ex 所有异常的父类 (多态接收可能抛出的异常)
     * @return 统一响应
     */
    @ExceptionHandler(Exception.class)
    public Result handler(Exception ex) {
        System.out.println("ex.getClass() = " + ex.getClass());
        ex.printStackTrace(); // 查看错误

        // 第三方类的异常
        // 自定义的异常
        if (ex instanceof CustomerException) {
//            String message = ex.getMessage();
            CustomerException ce = (CustomerException) ex;
            // throw ReusltCode 此时能取出来
            //ResultCode resultCode = ce.getResultCode();  // 参数枚举对象
            return Result.failure(ce.getResultCode());
        }else if (ex instanceof MethodArgumentNotValidException){
            // 取出MethodArgumentNotValidException中的错误数据
            MethodArgumentNotValidException mane= (MethodArgumentNotValidException) ex;
            // 绑定的错误字段结果
            BindingResult bindingResult = mane.getBindingResult();
            if (bindingResult.hasFieldErrors()) {
                // @NotNull(message = "配置名称不能为空")
                String errorMessage = bindingResult.getFieldErrors().get(0).getDefaultMessage();
                return Result.failure(errorMessage);
            }
        }
        // 其他异常
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);

    }
}