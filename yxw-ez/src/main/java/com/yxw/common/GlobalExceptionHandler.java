package com.yxw.common;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**        
 * Title: 全局异常处理切面    
 * Description: 
 * 利用 @ControllerAdvice + @ExceptionHandler 组合处理Controller层RuntimeException异常
 */      
@ControllerAdvice   // 控制器增强
@ResponseBody
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RespEntity handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
    	logger.error("could_not_read_json...", e);
        return RespEntityGenerator.genFailResp("could_not_read_json...");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public RespEntity handleValidationException(MethodArgumentNotValidException e) {
    	logger.error("parameter_validation_exception...", e);
        return RespEntityGenerator.genFailResp("parameter_validation_exception...");
    }

    /**
     * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RespEntity handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
    	logger.error("request_method_not_supported...", e);
        return RespEntityGenerator.genFailResp("request_method_not_supported");
    }

    /**
     * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
    public RespEntity handleHttpMediaTypeNotSupportedException(Exception e) {
    	logger.error("content_type_not_supported...", e);
        return RespEntityGenerator.genFailResp("content_type_not_supported");
    }

    /** 
     * 400 - Bad Request 
     */  
    @ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(ValidationException.class)  
    public RespEntity handleValidationException(ValidationException e) {  
    	logger.error("参数验证失败", e);  
        return RespEntityGenerator.genFailResp("validation_exception");  
    }  
    
    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public RespEntity handleException(Exception e) {
    	logger.error("Internal Server Error...", e);
        return RespEntityGenerator.genFailResp("服务器异常");
    }
    
}