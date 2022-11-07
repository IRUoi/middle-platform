package com.briup.cms.service.impl;

import com.briup.cms.service.IConfigService;
import com.briup.common.web.exception.CustomerException;
import com.briup.common.web.response.ResultCode;
import com.briup.user.bean.Config;
import com.briup.user.dao.ConfigMapper;
import com.briup.user.dao.extend.ConfigExtendMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/1/2022-11-01-11:27 AM
 * @Description：com.briup.cms.service.impl
 */
@Service
public class ConfigServiceImpl implements IConfigService {
    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private ConfigExtendMapper configExtendMapper;
    @Override
    public List<Config> selectList() {
       return configExtendMapper.selectList();
    }

    @Override
    public void addConfig(Config config) {
        configMapper.insert(config);
    }

    @Override
    public void updateConfig(Config config) {
        int rows = configExtendMapper.updateConfigWithoutStatus(config);
        if (rows < 1){
            throw new CustomerException(ResultCode.SPECIFIED_UPDATE_ERROR);
        }

    }

    //删除配置
    @Override
    public void deleteConfig(Integer id) {
        int row = configMapper.deleteByPrimaryKey(id);
        if (row > 0){
            throw new CustomerException(ResultCode.SPECIFIED_UPDATE_ERROR);
        }
    }

    //分页查找所有配置
    @Override
    public PageInfo selectListByPage(int pageNuber, int pageSize) {
        PageHelper.startPage(pageNuber,pageSize);
        List<Config> configList = configExtendMapper.selectAll();
        //以上是基于分页查询的结果
        //以下是根据结果构建的分页信息
        return new PageInfo(configList);
    }

    @Override
    public Config selectConfigByName(String name) {
        Config config = configExtendMapper.selectByName(name);
        return config;
    }
}
