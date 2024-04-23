package com.rui.bms.common.result;


import com.rui.bms.common.constant.ResultState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author rui
 * @since 2024-04-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel("响应参数封装对象")
public class ResultVO<T> {

    @ApiModelProperty("状态码")
    String state;

    @ApiModelProperty("状态信息")
    String msg;

    @ApiModelProperty("响应参数")
    T model;


    public static <T> ResultVO<T> success() {
        return success(null);
    }

    public static <T> ResultVO<T> success(T model) {
        return new ResultVO<>(ResultState.SUCCESS.getCode(), ResultState.SUCCESS.getMsg(), model);
    }

    public static <T> ResultVO<T> fail(String code, String msg) {
        return new ResultVO<>(code, msg, null);
    }

    public static <T> ResultVO<T> fail(ResultState resultState) {
        return fail(resultState, resultState.getMsg());
    }

    public static <T> ResultVO<T> fail(ResultState resultState, String msg) {
        return fail(resultState, msg, null);
    }

    public static <T> ResultVO<T> fail(ResultState resultState, String msg, T model) {
        if (Objects.isNull(msg)) {
            msg = resultState.getMsg();
        }
        return new ResultVO<>(resultState.getCode(), msg, model);
    }

}