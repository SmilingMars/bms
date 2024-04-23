package com.rui.bms.book.service;

import com.rui.bms.book.dto.BookDTO;
import com.rui.bms.book.entity.BookEntity;
import com.rui.bms.book.repository.BookRepository;
import com.rui.bms.book.transformer.BookTransformer;
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
public class BookService {

    BookRepository bookRepository;

    public BookDTO get(Long id, Long userId) {
        BookEntity entity = bookRepository.lambdaQuery()
                .eq(BookEntity::getId, id)
                .eq(BookEntity::getUserId, userId)
                .one();
        return BookTransformer.ENTITY_TO_DTO.apply(entity);
    }

    public boolean add(BookDTO bookDTO) {
        BookEntity entity = BookTransformer.DTO_TO_ENTITY.apply(bookDTO);
        return bookRepository.save(entity);
    }

    public boolean update(BookDTO bookDTO) {
        BookEntity entity = BookTransformer.DTO_TO_ENTITY.apply(bookDTO);
        return bookRepository.updateById(entity);
    }

    public boolean remove(Long id) {
        return bookRepository.removeById(id);
    }

}
