package br.com.alura.challenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API do Challenge Backend")
                        .version("v4")
                        .description("Conexos - Controle de Orçamento")
                        .termsOfService("http://localhost:8080/termsOfService")
                        .license(new License().name("Apache 2.0")
                                .url("http://localhost:8080/license")
                        )
                );
    }
}