package com.rui.bms.book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("book")
public class BookEntity {

    /**
     * 主键
     * TODO 换用雪花id等id生成策略
     */
    @TableId(type = IdType.AUTO)
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
