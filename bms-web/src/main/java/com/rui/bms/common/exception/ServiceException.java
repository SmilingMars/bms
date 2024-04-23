package com.rui.bms.common.exception;


import com.rui.bms.common.constant.ResultState;

/**
 * 自定义的服务异常
 *
 * @author rui
 * @since 2024-04-22
 */
public class ServiceException extends RuntimeException {

    /**
     * 状态码
     */
    private final String code;

    public ServiceException(ResultState resultState) {
        this(resultState.getCode(), resultState.getMsg());
    }

    public ServiceException(String message) {
        this(ResultState.BIZ_ERROR.getCode(), message);
    }

    public ServiceException(String code, String message) {
        super(message, null, false, false);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
