package br.com.ekan.testedev.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Atendimentos Médicos")
                        .version("1.0")
                        .description("API para gerenciar pacientes e seus atendimentos médicos, conforme o teste técnico da Ekan."));
    }
}
