package com.briup.cms.web.controller;

import com.briup.cms.service.IUserService;
import com.briup.common.web.util.PageUtil;
import com.briup.common.web.web.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @ApiOperation(value = "批量删除")
    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@ApiParam("批量删除id") @RequestBody List<Integer> ids){
        userService.deleteBatch(ids);
        return Result.success("批量删除成功");
    }
}
