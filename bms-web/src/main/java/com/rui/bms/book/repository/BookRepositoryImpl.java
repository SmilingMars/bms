package com.rui.bms.book.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.bms.book.entity.BookEntity;
import com.rui.bms.book.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
 * 图书 Repository 实现类
 *
 * @author rui
 * @since 2024-04-22
 */
@Service
public class BookRepositoryImpl extends ServiceImpl<BookMapper, BookEntity> implements BookRepository {

}
