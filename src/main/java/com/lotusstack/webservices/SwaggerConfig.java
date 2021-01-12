package com.lotusstack.webservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Webservices Documentation", "Application documentation", "1.0", "", "", "Apache", "");
    private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .consumes(DEFAULT_PRODUCES_CONSUMES).produces(DEFAULT_PRODUCES_CONSUMES);
//                .consumes();
    }
}
