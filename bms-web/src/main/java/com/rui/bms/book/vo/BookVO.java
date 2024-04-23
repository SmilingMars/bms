package com.rui.bms.book.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author rui
 * @since 2024-04-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(description = "图书信息")
public class BookVO {

    @ApiModelProperty("主键")
    Long id;

    @ApiModelProperty("书名")
    String name;

    @ApiModelProperty("作者")
    String author;

    @ApiModelProperty("国际标准书号")
    String isbn;
}
