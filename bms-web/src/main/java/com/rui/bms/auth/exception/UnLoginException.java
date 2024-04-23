package com.rui.bms.auth.exception;


import com.rui.bms.common.exception.ServiceException;
import com.rui.bms.common.constant.ResultState;

/**
 * 未登录异常
 *
 * @author rui
 * @since 2024-04-22
 */
public class UnLoginException extends ServiceException {

    public UnLoginException() {
        super(ResultState.UN_LOGIN);
    }

}
