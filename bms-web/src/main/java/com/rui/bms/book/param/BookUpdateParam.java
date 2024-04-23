package com.rui.bms.book.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ApiModel(description = "更新图书信息的请求参数")
public class BookUpdateParam {

    @NotNull(message = "主键不能为空")
    @ApiModelProperty(value = "主键")
    Long id;

    @NotBlank(message = "书名不能为空")
    @Size(max =64, message = "书名最大长度为64")
    @ApiModelProperty(value = "用户名", required = true)
    String name;

    @NotBlank(message = "作者不能为空")
    @Size(max = 16, message = "作者最大长度为16")
    @ApiModelProperty(value = "密码", required = true)
    String author;

    @NotBlank(message = "作者不能为空")
    @Size(max = 24, message = "国际标准书号最大长度为24")
    @ApiModelProperty(value = "", required = true)
    String isbn;

}
