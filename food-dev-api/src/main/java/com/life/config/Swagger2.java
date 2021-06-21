package com.life.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jc
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * http://localhost:8088/swagger-ui.html     原路径
     * http://localhost:8088/doc.html     原路径
     * 配置swagger2核心配置 docket
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        // 指定api类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.life.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("my project api")
                .contact(new Contact("jc", "www.jc.com", "1738203391@qq.com"))
                .description("A api for me practise")
                .version("1.0")
                .termsOfServiceUrl("www.jc")
                .build();
    }
}
