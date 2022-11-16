package com.briup.cms.web.controller;

import com.briup.cms.service.IUserService;
import com.briup.common.web.util.PageUtil;
import com.briup.common.web.web.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/14/2022-11-14-3:17 PM
 * @Description：com.briup.cms.web.controller
 */
@Api(tags = "用户模块")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "分页条件查询", notes = "条件为username和role")
    @PostMapping("/findByPage")
    public Result findByPage(@RequestBody PageUtil pageUtil){
        PageUtil data = userService.findByPage(pageUtil);
        return Result.success(data);
    }
}
