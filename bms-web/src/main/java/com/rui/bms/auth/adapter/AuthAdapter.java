package com.rui.bms.auth.adapter;

import com.rui.bms.auth.util.AuthCacheUtil;
import com.rui.bms.common.constant.ResultState;
import com.rui.bms.common.exception.ServiceException;
import java.util.Objects;
import java.util.UUID;
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
public class AuthAdapter {

    /**
     * 简单起见，先在代码中设置一个登录用的账号
     * TODO 改为数据库存储用户信息，并对密码做加密存储
     */
    private static final String NAME = "admin";
    private static final String PASSWORD = "admin";
    private static final Long USER_ID = 123456L;

    public String login(String name,String password) {
        if (!Objects.equals(NAME, name)) {
            throw new ServiceException(ResultState.ILLEGAL_LOGIN_INFO);
        }
        if (!Objects.equals(PASSWORD, password)) {
            throw new ServiceException(ResultState.ILLEGAL_LOGIN_INFO);
        }

        // TODO 先用 UUID 生成 token，后续再考虑替换
        // TODO 这里只返回 accessToken，后续再返回 refreshToken
        String accessToken = UUID.randomUUID().toString();

        // TODO 安全起见，需要先校验 accessToken 是否存在重复
        AuthCacheUtil.set(accessToken, USER_ID);
        return accessToken;
    }

    public void logout(String accessToken) {
        AuthCacheUtil.remove(accessToken);
    }
}
