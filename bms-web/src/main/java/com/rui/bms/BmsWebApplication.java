package com.rui.bms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rui
 * @since 2024-04-22
 */
@SpringBootApplication
@MapperScan("com.rui.bms.book.mapper")
public class BmsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsWebApplication.class, args);
    }
}
