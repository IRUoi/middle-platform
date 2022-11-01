package com.briup.cms.service.impl;

import com.briup.cms.service.IConfigService;
import com.briup.user.bean.Config;
import com.briup.user.dao.ConfigMapper;
import com.briup.user.dao.extend.ConfigExtendMapper;
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
//    @Autowired
//    private ConfigMapper configMapper;
    @Autowired
    private ConfigExtendMapper configExtendMapper;
    @Override
    public List<Config> selectList() {
       return configExtendMapper.selectList();
    }
}
