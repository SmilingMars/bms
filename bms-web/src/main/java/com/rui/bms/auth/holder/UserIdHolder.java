package com.rui.bms.auth.holder;

import com.rui.bms.auth.exception.UnLoginException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * 本类用于保存、获取当前登录的用户信息
 *
 * @author rui
 * @since 2024-04-22
 */
@Slf4j
public class UserIdHolder {

    private static final ThreadLocal<Long> USER_ID_THREAD_LOCAL = new ThreadLocal<>();


    /**
     * 从上下文中获取 userId
     * 若 userId 不存在，则抛出 未登录异常{@link UnLoginException}
     */
    public static Long userId() {
        Long userId = USER_ID_THREAD_LOCAL.get();
        if (Objects.isNull(userId)) {
            log.info("fail to get userId");
            throw new UnLoginException();
        }

        return userId;
    }

    public static void set(Long userId) {
        USER_ID_THREAD_LOCAL.set(userId);
    }

    public static void clear() {
        USER_ID_THREAD_LOCAL.remove();
    }


}
