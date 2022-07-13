package com.demo.incubator.swaggerdemo.config;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    Docket flightSystem() {
        return new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                        .paths(PathSelectors.any())
                        .build();
    }
}

