package com.rui.bms.book.controller;

import com.rui.bms.book.adapter.BookAdapter;
import com.rui.bms.book.param.BookAddParam;
import com.rui.bms.book.param.BookUpdateParam;
import com.rui.bms.book.param.IdParam;
import com.rui.bms.book.vo.BookVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rui
 * @since 2024-04-22
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "图书信息接口")
@RequestMapping("book")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {

    BookAdapter bookAdapter;

    @GetMapping("get")
    @ApiOperation("根据id查询图书")
    public BookVO get(@RequestParam("id") Long id) {
        return bookAdapter.get(id);
    }

    @PostMapping("add")
    @ApiOperation("新增图书")
    public boolean add(@RequestBody @Valid BookAddParam param) {
        return bookAdapter.add(param);
    }

    @PostMapping("update")
    @ApiOperation("更新图书")
    public boolean update(@RequestBody @Valid BookUpdateParam param) {
        return bookAdapter.update(param);
    }

    @PostMapping("remove")
    @ApiOperation("删除图书")
    public boolean remove(@RequestBody @Valid IdParam param) {
        return bookAdapter.remove(param.getId());
    }

}
