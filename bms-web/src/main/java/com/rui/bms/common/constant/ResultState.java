package com.rui.bms.common.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * 通用状态码
 *
 * @author rui
 * @since 2024-04-22
 */
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ResultState {

    /**
     * 0  : 请求成功
     * -1 : 其它异常
     */
    SUCCESS("0", "请求成功"),
    OTHER_ERROR("-1", "其它异常"),

    /**
     * 41*** : 登录、鉴权等验证信息错误
     */
    ILLEGAL_LOGIN_INFO("41001", "用户名或密码错误"),
    UN_LOGIN("41002", "用户未登录"),


    /**
     * 42*** : 参数校验信息错误
     */
    MISSING_ARGS("42001", "缺少必传参数"),
    ILLEGAL_ARGS("42002", "非法参数值"),


    /**
     * 43*** : 业务异常
     */
    BIZ_ERROR("43000", "业务异常");

    /**
     * 状态码
     */
    String code;
    /**
     * 状态信息
     */
    String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}