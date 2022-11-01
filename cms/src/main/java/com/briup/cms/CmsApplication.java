package com.briup.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: ZHU(lc))
 * @Date: 10/31/2022-10-31-1:24 PM
 * @Description：com.briup.cms
 */
@SpringBootApplication
@MapperScan(CmsApplication.MAPPERBASEPACKAGE)
public class CmsApplication {
    public static final String MAPPERBASEPACKAGE = "com.briup.user.dao";
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class,args);
    }
}
