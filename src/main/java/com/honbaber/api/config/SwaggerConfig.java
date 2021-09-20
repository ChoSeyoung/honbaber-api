package com.honbaber.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerClientApi() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .groupName("client")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.honbaber.api.controller"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket swaggerAdminApi() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .groupName("admin")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.honbaber.admin.api.controller"))
                .paths(PathSelectors.ant("/admin/api/**"))
                .build()
                .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("honbaber")
                .description("This page is offered for honbaber API viewer")
                .version("1.0")
                .build();
    }
    
}
