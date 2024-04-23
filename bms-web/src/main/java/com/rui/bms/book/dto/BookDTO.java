package com.rui.bms.book.dto;

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
public class BookDTO {

    /**
     * 主键
     */
    Long id;

    /**
     * 用户id
     */
    Long userId;

    /**
     * 书名
     */
    String name;

    /**
     * 作者
     */
    String author;

    /**
     * 国际标准书号
     */
    String isbn;

    /**
     * 是否已删除
     * 0-未删除，1-已删除
     */
    Integer isDelete;


}
