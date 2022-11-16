package com.briup.common.web.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.AuthorizationScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
                .securityContexts(securityContexts())
                .securitySchemes(security())
                .apiInfo(getapiInfo()); // ApiInfo 文档描述信息
    }

    private ApiInfo getapiInfo() {
        return new ApiInfoBuilder()
                .title("中台管理系统")
                .build();
    }
    // swagger 集成 token
    private List<SecurityContext> securityContexts() {
        // 例如，/auth/** 和jwt保持一致
        List<String> antPaths = new ArrayList<>(Arrays.asList("/config/**","/user/**","/auth/**"));

        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())

                        .forPaths(antPathsCondition(antPaths))
                        .build()
        );
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(
                new SecurityReference("Authorization", authorizationScopes));
    }

    private Predicate<String> antPathsCondition(List<String> antPaths){
//   if(antPaths==null||antPaths.size()==0) {
//     antPaths = new ArrayList<>();
//     antPaths.add("/**");
//   }
        List<Predicate<String>> list = new ArrayList<>();

        antPaths.forEach(path->list.add(PathSelectors.ant(path)));

        return Predicates.or(list);

    }

    private List<ApiKey> security() {
        return Collections.singletonList(
                new ApiKey("Authorization", "Authorization", "header")
        );
    }


}