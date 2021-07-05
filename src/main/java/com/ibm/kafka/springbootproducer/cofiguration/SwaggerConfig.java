package com.ibm.kafka.springbootproducer.cofiguration;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;



@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.ibm.kafka.springbootproducer"))
                .build();

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Employee Producer API").description("Kafka producer for employee service").version("V1").build();
    }
}
