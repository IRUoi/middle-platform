package com.briup.cms.web.controller;

import com.briup.cms.service.IConfigService;
import com.briup.common.web.exception.CustomerException;
import com.briup.common.web.response.Result;
import com.briup.common.web.response.ResultCode;
import com.briup.user.bean.Config;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/1/2022-11-01-11:20 AM
 * @Description：com.briup.cms.web.controller
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private IConfigService configService;

    @ApiOperation(value = "查询已启动的配置")
    @GetMapping("/listConfig")
    public Result selectConfigStatusWithOn(){
        List<Config> configs = configService.selectList();
//        int i = 0;
//        if (i == 0) {
//            throw new RuntimeException("异常");
//
//        }
        return Result.success(configs);
    }
    @ApiOperation(value = "添加新的配置信息")
    @PostMapping("/addConfig")
    public Result addConfig(@RequestBody @Valid Config config){
        String name = config.getConfigName();

        if (null==configService.selectConfigByName(name)){
            configService.addConfig(config);
            return Result.success("添加成功");
        }else{
            throw new CustomerException(ResultCode.SPECIFIED_CONFIG_NAME_UNIQUE);
        }
    }

    @ApiOperation(value = "更新配置",notes = "不更新状态和名称")
    @PutMapping("/updateConfig")
    public Result updateConfig(@RequestBody Config config){
        configService.updateConfig(config);
        return Result.success("修改成功");
    }

    @ApiOperation(value = "删除配置",notes = "目前是物理删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", dataType = "int",paramType = "path", required = true)
    })
    @DeleteMapping("/deleteConfig/{id}")
    public Result deleteConfig(@PathVariable Integer id, @PathVariable Integer status){
        configService.deleteConfig(id);
        return Result.success("删除成功");
    }
    @ApiOperation(value = "分页查询所有配置", notes = "提供分页参数")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页", name = "pageNumber", dataType = "Integer", paramType = "path",defaultValue = "0"),
            @ApiImplicitParam(value = "每页条数", name = "pageSize", dataType = "Integer", paramType = "path",defaultValue = "5")

    })
    @GetMapping("/selectByPage/{pageNumber}/{pageSize}")
    public Result selectByPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        PageInfo pageInfo = configService.selectListByPage(pageNumber, pageSize);
        return Result.success(pageInfo);

    }


}
