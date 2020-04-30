package br.codenation.projectfinal.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.codenation.projectfinal"))
                .build()
                .apiInfo(metaData())
                .securitySchemes(Collections.singletonList(oauth()))
                .securityContexts(Collections.singletonList(securityContext()));

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Central de Logs API")
                .description("\"API documentation\"")
                .version("1.0.0")
                .contact(new Contact("Marden Rocha","https://github.com/gabrielmarden","mardenbiel@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    List<GrantType> grantTypes(){
        List<GrantType> grantTypes = new ArrayList<>();
        grantTypes.add(new ResourceOwnerPasswordCredentialsGrant("https://central-de-logs-api.herokuapp.com/oauth/token"));
        return grantTypes;
    }

    @Bean
    SecurityScheme oauth(){
        return new OAuthBuilder()
                .name("OAuth2")
                .scopes(scopes())
                .grantTypes(grantTypes())
                .build();
    }

    private List<AuthorizationScope> scopes(){
        List<AuthorizationScope> list = new ArrayList<>();
        list.add(new AuthorizationScope("read","Grant read access"));
        list.add(new AuthorizationScope("write","Grant write access"));
        list.add(new AuthorizationScope("trust","Grant read write and delete access"));
        return list;
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant("/user/**"))
                .build();
    }

    private List<SecurityReference> defaultAuth(){
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[2];

        authorizationScopes[0] = new AuthorizationScope("read","Grant read access");
        authorizationScopes[1] = new AuthorizationScope("read","Grant write access");

        return Collections.singletonList(new SecurityReference("Oauth2Scheme",authorizationScopes));
    }

}
