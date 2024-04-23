package com.rui.bms.auth.controller;

import com.rui.bms.auth.adapter.AuthAdapter;
import com.rui.bms.auth.annotation.NoAuth;
import com.rui.bms.auth.constant.AuthConstant;
import com.rui.bms.auth.param.UserLoginParam;
import com.rui.bms.common.result.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rui
 * @since 2024-04-22
 */
@Slf4j
@RestController
@AllArgsConstructor
@Api(tags = "登录接口")
@RequestMapping("auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    AuthAdapter authAdapter;

    @PostMapping("login")
    @ApiOperation("登录")
    @NoAuth
    public ResultVO<String> login(@RequestBody @Valid UserLoginParam param) {
        String accessToken = authAdapter.login(param.getName(), param.getPassword());
        return ResultVO.success(accessToken);
    }

    @PostMapping("logout")
    @ApiOperation("退出登录")
    public void logout(@RequestHeader(AuthConstant.ACCESS_TOKEN) String accessToken) {
        authAdapter.logout(accessToken);
    }



}
