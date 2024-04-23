package com.rui.bms.book.adapter;

import com.rui.bms.auth.holder.UserIdHolder;
import com.rui.bms.book.dto.BookDTO;
import com.rui.bms.book.param.BookAddParam;
import com.rui.bms.book.param.BookUpdateParam;
import com.rui.bms.book.service.BookService;
import com.rui.bms.book.transformer.BookTransformer;
import com.rui.bms.book.vo.BookVO;
import com.rui.bms.common.exception.ServiceException;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author rui
 * @since 2024-04-22
 */
@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookAdapter {

    BookService bookService;

    public BookVO get(Long id) {
        Long userId = UserIdHolder.userId();
        BookDTO bookDTO = bookService.get(id, userId);
        return BookTransformer.DTO_TO_VO.apply(bookDTO);
    }

    public boolean add(BookAddParam param) {
        BookDTO dto = BookTransformer.ADD_PARAM_TO_DTO.apply(param);
        Long userId = UserIdHolder.userId();
        dto.setUserId(userId);
        return bookService.add(dto);
    }

    public boolean update(BookUpdateParam param) {
        this.checkUserInfo(param.getId());

        BookDTO dto = BookTransformer.UPDATE_PARAM_TO_DTO.apply(param);
        return bookService.update(dto);
    }

    private void checkUserInfo(Long id) {
        Long userId = UserIdHolder.userId();
        BookDTO bookDTO = bookService.get(id, userId);
        if (Objects.isNull(bookDTO)) {
            throw new ServiceException("图书不存在");
        }
    }

    public boolean remove(Long id) {
        this.checkUserInfo(id);
        return bookService.remove(id);
    }
}
