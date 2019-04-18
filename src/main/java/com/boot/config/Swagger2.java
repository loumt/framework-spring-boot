package com.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2 {

    @Value("${swagger.show}")
    private boolean swaggerShow;

    @Value("${swagger.basePackage}")
    private String basePackage;

    @Value("${swagger.groupName}")
    private String groupName;

    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                .title("SpringBoot 利用Swagger构建Api文档")
                .description("API文档的描述")
                .termsOfServiceUrl("http://192.168.20.116:8080/")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(this.swaggerShow)
                .apiInfo(buildApiInfo())
                .enableUrlTemplating(true)
                .groupName(this.groupName)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build();
    }
}
