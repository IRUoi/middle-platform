package com.briup.cms.web.controller;

import com.briup.cms.service.IConfigService;
import com.briup.user.bean.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/")
    public List<Config> selectConfigStatusWithOn(){
        return configService.selectList();
    }
}
