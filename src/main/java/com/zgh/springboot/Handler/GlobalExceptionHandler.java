package com.zgh.springboot.Handler;


import com.zgh.springboot.common.RestResult;
import com.zgh.springboot.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Set;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @Value("${exception.show}")
    private String showException="";

    // 异常处理方法：
    // 根据特定的异常返回指定的 HTTP 状态码
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public RestResult handleValidationException(HttpServletRequest request, ConstraintViolationException ex) {
        logger.error("异常:"+request.getRequestURI(),ex);
        Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : errors) {
            strBuilder.append(violation.getMessage() + "\n");
        }
        return RestResult.Fail("Bad_request-error", strBuilder.toString());
    }


    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value=MethodArgumentNotValidException.class) //400
    @ResponseBody
    public RestResult MethodArgumentNotValidHandler(HttpServletRequest request,
                                                    MethodArgumentNotValidException exception) throws Exception
    {
        logger.error("异常:"+request.getRequestURI(),exception);
        HashMap<String,String> errortip=new HashMap<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errortip.put(error.getField(),error.getDefaultMessage());
        }

        return RestResult.Fail("Argument-error","请求参数错误",errortip);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public RestResult NoHandlerFoundException(HttpServletRequest request, Exception ex) {
        logger.error("异常:"+request.getRequestURI(),ex);
        return RestResult.Fail("NoHandlerFound-error","找不到接口地址："+request.getRequestURI().toString());
    }


    // 通用异常的处理，返回500
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResult handleException(HttpServletRequest request, Exception ex) {
        logger.error("异常:"+request.getRequestURI(),ex);
        request.setAttribute("sysLoginCode",null);
        if(ex instanceof BaseException){
            BaseException baseex=(BaseException)ex;
            return RestResult.Fail(baseex.getCode(),baseex.getMessage());
        }
        if(ex instanceof  org.springframework.web.multipart.MultipartException){
            return RestResult.Fail("0000","文件太大");
        }
        if(ex instanceof com.alibaba.fastjson.JSONException){
            return RestResult.Fail("server-error","请求参数格式不正确");
        }
        if(ex instanceof org.springframework.web.HttpRequestMethodNotSupportedException){
            return RestResult.Fail("server-error","请求方法不正确");
        }
        if(this.showException!=null && this.showException.toLowerCase().equals("true")) {
            return RestResult.Fail("server-error", ex.getMessage());//this.getExceptionDetail(ex)
        }
        else {
            return RestResult.Fail("server-error", "请求不正确，服务器处理异常");
        }

    }

    private String getExceptionDetail(Exception e) {
        StringBuffer stringBuffer = new StringBuffer(e.toString() + "\n");
        StackTraceElement[] messages = e.getStackTrace();
        int length = messages.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(messages[i].toString()+"\n");
        }
        return stringBuffer.toString();
    }
}


