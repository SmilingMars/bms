package com.rui.bms.common.advice;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rui.bms.common.annotation.Unboxing;
import com.rui.bms.common.result.ResultVO;
import java.util.Objects;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 响应参数包装类
 *
 * @author rui
 * @since 2024-04-22
 */
@Order(2)
@ControllerAdvice("com.rui.bms")
public class ResultBoxAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (Objects.equals(returnType.getParameterType(), ResultVO.class)) {
            return false;
        }
        if (returnType.hasMethodAnnotation(Unboxing.class)) {
            return false;
        }
        return true;


    }

    @Override
    @SneakyThrows
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResultVO<Object> result = ResultVO.success(body);
        if (!Objects.equals(returnType.getParameterType(), String.class)) {
            return result;
        }


        // 方法返回类型是String，则将包装后的响应参数，转为Json格式
        ObjectMapper objectMapper = new ObjectMapper();
        String resultJson = objectMapper.writeValueAsString(result);
        return resultJson;
    }

}
