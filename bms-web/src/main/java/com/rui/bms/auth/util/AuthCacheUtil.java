package com.rui.bms.auth.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 鉴权信息缓存
 * key：value = accessToken：userId
 *
 * TODO 改为 redis 存储
 *
 * @author rui
 * @since 2024-04-22
 */
public class AuthCacheUtil {

    private final static Cache<String, Long> CACHE = CacheBuilder.newBuilder()
            .concurrencyLevel(4)
            .initialCapacity(16)
            .maximumSize(256)
            .expireAfterWrite(1, TimeUnit.HOURS)
            .build();


    public static Optional<Long> get(String accessToken) {
        Long userId = CACHE.getIfPresent(accessToken);
        return Optional.ofNullable(userId);
    }

    public static void set(String accessToken, Long userId) {
        CACHE.put(accessToken, userId);
    }

    public static void remove(String accessToken) {
        CACHE.invalidate(accessToken);
    }

}
