package com.br.sistema_teste.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringOpenApiConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Sistema de teste")
                                .description("Sistema de teste para aprendizagem")
                                .version("V1")
                                .contact(new Contact().name("Leandro").email("leandro@email.com"))
                );
    }
}
