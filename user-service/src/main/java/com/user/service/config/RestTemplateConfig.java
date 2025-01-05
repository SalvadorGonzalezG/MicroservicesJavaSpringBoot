package com.user.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Clase de configuracion en spring y puede definir bean que se administran en el contenedor de Spring
@Configuration
public class RestTemplateConfig {

	// Metodo que define un bean de tipo RestTemplate
	// al estar anotado con @Bean, el contenedor de String administrara este objeto
	// permitiendo su inyeccion en otras partes de la aplicacion cuando se requiera
	@Bean
	public RestTemplate restTemplate() {
		
		// Crea y retorna una nueva instancia de RestTemplate
		// RestTemplate lo utilizamos para realizar llamadas HTTP a servicios externos.
		return new RestTemplate();
	}
}
