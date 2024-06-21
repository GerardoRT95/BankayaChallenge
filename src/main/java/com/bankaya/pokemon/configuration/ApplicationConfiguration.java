package com.bankaya.pokemon.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

	//Creacion del objeto para realizar peticion rest y se sube al contexto
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
