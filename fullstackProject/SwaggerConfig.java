package com.springformmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//SWAGGER2--固定寫法
//開啟方式網址輸入:專案名稱/swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.springformmvc"))
            .build()
           // .pathMapping("/mvSpringSwagger1107") // Set the path mapping
            .apiInfo(new ApiInfoBuilder().title("supplier API").build());
    }
}

