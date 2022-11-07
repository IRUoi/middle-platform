package com.briup.cms;

import com.briup.user.bean.Config;
import com.briup.user.dao.ConfigMapper;
import com.briup.user.dao.extend.ConfigExtendMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/1/2022-11-01-10:56 AM
 * @Description：PACKAGE_NAME
 */
@SpringBootTest
public class TestMybatis {
    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private ConfigExtendMapper configExtendMapper;

    @Test
    public void Test(){
        Config config = configMapper.selectByPrimaryKey(2);
        System.out.println("config = " + config);
    }
    @Test
    public void Test1(){
        Config config = configExtendMapper.selectByName("工厂资讯管理系统");
        System.out.println(config.toString());

    }
}
