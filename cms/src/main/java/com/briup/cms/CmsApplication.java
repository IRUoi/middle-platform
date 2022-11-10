package com.briup.cms;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: ZHU(lc))
 * @Date: 10/31/2022-10-31-1:24 PM
 * @Description：com.briup.cms
 */

@SpringBootApplication(scanBasePackages = {"com.briup.common", "com.briup.cms"})
@MapperScan(CmsApplication.MAPPERBASEPACKAGE)
//@EnableScheduling
public class CmsApplication {
    public static final String MAPPERBASEPACKAGE = "com.briup.user.dao";

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
