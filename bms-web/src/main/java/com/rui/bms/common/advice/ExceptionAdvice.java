package com.rui.bms.common.advice;


import com.rui.bms.common.constant.ResultState;
import com.rui.bms.common.exception.ServiceException;
import com.rui.bms.common.result.ResultVO;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 统一异常处理类
 *
 * @author rui
 * @since 2024-04-22
 */
@Slf4j
@Order(1)
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BindException.class)
    public ResultVO<Void> bindExceptionHandler(BindException bindException) {
        FieldError fieldError = bindException.getBindingResult().getFieldError();
        return buildResultVO(fieldError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<Void> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        return buildResultVO(fieldError);
    }

    private ResultVO<Void> buildResultVO(FieldError fieldError) {
        String errMsg = Optional.ofNullable(fieldError)
                .map(FieldError::getDefaultMessage)
                .orElse(null);
        return ResultVO.fail(ResultState.ILLEGAL_ARGS, errMsg);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVO<Void> methodArgumentNotValidExceptionHandler(MethodArgumentTypeMismatchException exception) {
        String errMsg = Optional.ofNullable(exception.getValue())
                .map(v -> v + " 参数格式错误")
                .orElse(null);
        return ResultVO.fail(ResultState.ILLEGAL_ARGS, errMsg);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVO<Void> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException exception) {
        return ResultVO.fail(ResultState.ILLEGAL_ARGS, exception.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpMessageConversionException.class})
    public ResultVO<Void> requestBodyExceptionHandler(Exception exception) {
        String errMsg = Optional.ofNullable(exception.getCause())
                .map(Throwable::getCause)
                .map(Throwable::getMessage)
                .orElse(null);
        return ResultVO.fail(ResultState.ILLEGAL_ARGS, errMsg);
    }

    @ExceptionHandler(ServiceException.class)
    public ResultVO<Void> exceptionHandler(ServiceException exception) {
        return ResultVO.fail(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO<Void> exceptionHandler(Exception exception) {
        log.error("", exception);
        return ResultVO.fail(ResultState.OTHER_ERROR);
    }


}
