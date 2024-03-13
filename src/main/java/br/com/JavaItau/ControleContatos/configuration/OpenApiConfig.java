package br.com.JavaItau.ControleContatos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearerAuth",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWt")))
				.info(new Info().title("API Gerenciadora de Pessoas e Contatos")
						.description(" Está api será responsavel por gerenciar pessoas e contatos")
						.contact(new Contact().name("Gabriel Fragata Rousseau").email("gfragata97@gmail.com")
								.url("http://localhost:8081/swagger-ui/index.html"))
						.version("Versão 0.0.1-SNAPSHOT"))
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}
}
