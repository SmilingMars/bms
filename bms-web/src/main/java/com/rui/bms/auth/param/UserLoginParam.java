package com.rui.bms.auth.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author rui
 * @since 2024-04-22
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "用户登录信息请求参数")
public class UserLoginParam {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max =16, message = "用户名长度应为4-16位")
    @ApiModelProperty(value = "用户名", required = true)
    String name;

    @NotBlank(message = "密码不能为空")
    @Size(min = 4, max = 16, message = "密码长度应为4-16位")
    @ApiModelProperty(value = "密码", required = true)
    String password;

}
