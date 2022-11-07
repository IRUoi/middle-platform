package com.briup.common.web.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/2/2022-11-02-3:58 PM
 * @Description：com.briup.common.web.config
 */


@Configuration
@EnableSwagger2
public class Swagger2Config {
    // 定制swagger-ui页面信息 Docket 放入容器中
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()  // ApiSelectorBuilder 哪些api需要扫描 Predicate test
//                .apis(RequestHandlerSelectors.basePackage("com.briup.cms.web.controller")) // 哪个controller
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) // 带Api注解的就会扫描
                .paths(PathSelectors.ant("/**")) // 哪些方法
                .build()
                .apiInfo(getapiInfo()); // ApiInfo 文档描述信息
    }

    private ApiInfo getapiInfo() {
        return new ApiInfoBuilder()
                .title("中台管理系统")
                .description("jd2204全体开发")
                .build();
    }

}