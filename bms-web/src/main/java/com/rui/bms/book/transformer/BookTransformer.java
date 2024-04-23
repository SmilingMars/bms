package com.rui.bms.book.transformer;

import com.rui.bms.book.dto.BookDTO;
import com.rui.bms.book.entity.BookEntity;
import com.rui.bms.book.param.BookAddParam;
import com.rui.bms.book.param.BookUpdateParam;
import com.rui.bms.book.vo.BookVO;
import java.util.Objects;
import java.util.function.Function;
import org.springframework.beans.BeanUtils;

/**
 * BO 转换器
 *
 * @author rui
 * @since 2024-04-22
 */
public final class BookTransformer {

    public static final Function<BookDTO, BookVO> DTO_TO_VO = dto -> {
        if (Objects.isNull(dto)) {
            return null;
        }

        BookVO vo = new BookVO();
        BeanUtils.copyProperties(dto, vo);
        return vo;
    };

    public static final Function<BookDTO, BookEntity> DTO_TO_ENTITY = dto -> {
        if (Objects.isNull(dto)) {
            return null;
        }

        BookEntity entity = new BookEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    };

    public static final Function<BookEntity, BookDTO> ENTITY_TO_DTO = entity -> {
        if (Objects.isNull(entity)) {
            return null;
        }
        BookDTO dto = new BookDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    };

    public static final Function<BookAddParam, BookDTO> ADD_PARAM_TO_DTO = param -> {
        if (Objects.isNull(param)) {
            return null;
        }
        BookDTO dto = new BookDTO();
        BeanUtils.copyProperties(param, dto);
        dto.setIsDelete(0);
        return dto;
    };

    public static final Function<BookUpdateParam, BookDTO> UPDATE_PARAM_TO_DTO = param -> {
        if (Objects.isNull(param)) {
            return null;
        }
        BookDTO dto = new BookDTO();
        BeanUtils.copyProperties(param, dto);
        return dto;
    };

}
