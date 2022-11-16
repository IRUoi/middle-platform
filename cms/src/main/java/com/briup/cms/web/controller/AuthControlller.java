package com.briup.cms.web.controller;

import com.briup.cms.dto.UserDto;
import com.briup.cms.service.IUserService;
import com.briup.common.web.web.response.Result;
import com.briup.user.bean.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

    @ApiOperation(value = "获取当前用户信息", notes = "首页显示")
    @GetMapping("/currentInfo")
    public Result info(@ApiIgnore @RequestHeader("Authorization") String token){
        User user = userService.currentInfo(token);
        return Result.success(user);
    }
}
