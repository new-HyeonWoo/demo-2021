package com.example.demo.common.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 설정
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String TAG_1 = "모듈 이름";

    /**
     * 스웨거 API 문서 생성
     */
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any()) // 모든 Controller들이 있는 패키지를 탐색해서 API 문서를 만든다.
            .paths(PathSelectors.any()) // 노출이 되지 않아야 하는 API가 있다면 path를 지정해준다.
            .build()
            .apiInfo(this.apiInfo()); // 스웨거 정보 등록.
//                .tags(new Tag(TAG_1, "description")) // Tag 설정시 Controller에 @Api(tags={SwaggerConfiguration.TAG_1}) 사용
//                .useDefaultResponseMessages(true); // 기본으로 셋팅되는 200, 401, 403, 404 메시지 표시.
    }

    /**
     * 스웨거 정보
     * (Docket 클래스를 만들때 추가하는 정보)
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("String Boot API 문서")
                .description("Spring Boot 마켓컬리")
                .version("1.0")
                .build();
    }
}
