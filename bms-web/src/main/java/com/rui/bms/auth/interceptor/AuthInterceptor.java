package com.rui.bms.auth.interceptor;


import com.rui.bms.auth.annotation.NoAuth;
import com.rui.bms.auth.constant.AuthConstant;
import com.rui.bms.auth.exception.UnLoginException;
import com.rui.bms.auth.holder.UserIdHolder;
import com.rui.bms.auth.util.AuthCacheUtil;
import com.rui.bms.common.advice.ExceptionAdvice;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录认证拦截器
 * 这里抛出的异常，会被 {@link ExceptionAdvice} 拦截处理
 *
 * @author rui
 * @since 2024-04-22
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            // 只拦截Controller方法
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;

        // 不拦截被 @NoAuth 标记的类或方法
        NoAuth noAuthenticForBean = method.getBeanType().getAnnotation(NoAuth.class);
        if (Objects.nonNull(noAuthenticForBean)) {
            return true;
        }
        NoAuth noAuthenticForMethod = method.getMethodAnnotation(NoAuth.class);
        if (Objects.nonNull(noAuthenticForMethod)) {
            return true;
        }

        // 将用户信息放入线程上下文
        Long userId = this.acquireUserId(request);
        UserIdHolder.set(userId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        // 清除线程上下文中的用户信息
        UserIdHolder.clear();
    }

    private Long acquireUserId(HttpServletRequest request) {
        String accessToken = request.getHeader(AuthConstant.ACCESS_TOKEN);
        if (StringUtils.isBlank(accessToken)) {
            log.info("accessToken is blank");
            throw new UnLoginException();
        }

        // 从缓存中获取 userId
        Long userId = AuthCacheUtil.get(accessToken)
                .orElseThrow(UnLoginException::new);
        return userId;
    }


}
