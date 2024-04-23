package com.rui.bms.book.param;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author rui
 * @since 2024-04-22
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "主键请求参数")
public class IdParam {

    @NotNull(message = "主键不能为空")
    Long id;
}
