package com.briup.cms.web.controller;

import com.briup.cms.dto.UserDto;
import com.briup.cms.service.IUserService;
import com.briup.common.web.web.response.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/7/2022-11-07-5:17 PM
 * @Description：com.briup.cms.web.controller
 */
@Api(tags = "认证模块" )
@RestController
@RequestMapping("/auth")
public class AuthControlller {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登录",notes = "用户名和密码")
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "", name = "")
    })
    public Result Login(@RequestBody @ApiParam("认证类") UserDto userDto){
        String token = userService.login(userDto);
        return Result.success(token);
    }
}
