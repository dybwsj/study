package com.self.study.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 16:08
 * @ConditionalOnExpression: 开启访问接口文档的权限  **knife4j.enable是在yml配置文件中配置为true**
 * @description:
 */

@Configurable
@EnableKnife4j
@ConditionalOnExpression(value = "${knife4j.enable}")
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.self.study.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot相关内容学习")
                .description("更努力更加油")
                .version("1.0")
                .contact(new Contact("Study OpenApi",
                        "http://localhost:9029/doc.html",
                        "841869018@qq.com"))
                .build();
    }
}
