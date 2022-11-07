package com.briup.cms.service;

import com.briup.user.bean.Config;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/1/2022-11-01-11:24 AM
 * @Description：com.briup.cms.service
 */
public interface IConfigService {
    //查询所有配置
    List<Config> selectList();
    //添加配置
    void addConfig(Config config);
    //修改配置
    void updateConfig(Config config);
    //删除配置
    void deleteConfig(Integer id);
    //分页查找所有配置
    PageInfo selectListByPage(int currentPage,int pageSize);

    Config selectConfigByName(String name);
}
