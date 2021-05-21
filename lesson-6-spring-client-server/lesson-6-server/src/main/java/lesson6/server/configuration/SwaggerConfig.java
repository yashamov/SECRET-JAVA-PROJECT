/*package lesson6.server.configuration;
import com.google.common.base.Predicates;
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

import java.util.Optional;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)//
                .select()
                .apis(RequestHandlerSelectors.basePackage("lesson6.server.controllers"))
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(metadata())
                .useDefaultResponseMessages(false)
                .pathMapping("")
                .genericModelSubstitutes(Optional.class);
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Goldman Sex")
                .version("3.2.2")
                .contact(new Contact("Dima <3 Roma <3 Yarik", "vk.com", null))
                .build();
    }
}
*/