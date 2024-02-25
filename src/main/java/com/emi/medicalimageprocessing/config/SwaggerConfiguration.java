package com.emi.medicalimageprocessing.config;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.emi.medicalimageprocessing.utils.Constants.APP_ROOT;
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Medical Image processing API documentation")
                                .title("Medical Image processing REST API")
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emi.medicalimageprocessing"))
                .paths(PathSelectors.ant(APP_ROOT + "/**"))
                .build();
    }
}