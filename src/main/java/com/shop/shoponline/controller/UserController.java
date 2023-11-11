package com.shop.shoponline.controller;

import com.shop.shoponline.common.result.Result;
import com.shop.shoponline.query.UserLoginQuery;
import com.shop.shoponline.service.UserService;
import com.shop.shoponline.vo.LoginResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zero
 * @since 2023-11-07
 */
@Tag(name = "用户模块")
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "微信登录")
    @PostMapping("login/wxMin")
    public Result<LoginResultVO> wxLogin(@RequestBody @Validated UserLoginQuery query) {
        LoginResultVO userVO = userService.login(query);
        return Result.ok(userVO);
    }
}
