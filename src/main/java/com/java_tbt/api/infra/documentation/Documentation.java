package com.java_tbt.api.infra.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class Documentation {

    @Bean
    public OpenAPI openAPIDocumentation() {
        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes("bearer-key",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")));
    }

}
