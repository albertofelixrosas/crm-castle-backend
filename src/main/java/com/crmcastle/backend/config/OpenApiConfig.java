package com.crmcastle.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI crmOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRM Castle API")
                        .version("v1")
                        .description("Mini CRM API inspired by Salesforce")
                        .contact(new Contact().name("CRM Castle Team").email("dev@crmcastle.local")));
    }
}
