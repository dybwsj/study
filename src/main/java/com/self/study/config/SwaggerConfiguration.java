package com.self.study.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 16:08
 * @ConditionalOnExpression: 开启访问接口文档的权限  **knife4j.enable是在yml配置文件中配置为true**
 * @description:
 */

@Configurable
@EnableKnife4j
@EnableSwagger2
@ConditionalOnExpression("${knife4j.enable}")
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost")
//                .enable()
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.self.study.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs(带认证）")
                .description("更多Spring Boot相关文章请关注：https://blog.csdn.net/elvishehai")
                .termsOfServiceUrl("https://blog.csdn.net/elvishehai")
                .version("1.0")
                .build();
    }
}
