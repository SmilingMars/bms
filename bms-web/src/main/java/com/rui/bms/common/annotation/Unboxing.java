package com.rui.bms.common.annotation;


import com.rui.bms.common.advice.ResultBoxAdvice;
import com.rui.bms.common.result.ResultVO;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记不需要执行默认 ResultVO 装箱的方法
 * 即，标记了本注解的方法，其返回值，不会被 {@link ResultBoxAdvice} 包装成 {@link ResultVO} 格式
 *
 * @author rui
 * @since 2024-04-22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Unboxing {
}
