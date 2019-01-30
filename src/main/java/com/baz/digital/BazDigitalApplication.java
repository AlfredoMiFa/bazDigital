package com.baz.digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.baz.digital.config.SwaggerConfiguration;

@ComponentScan("com.baz.digital.services")
@ComponentScan("com.baz.digital")
@Import(SwaggerConfiguration.class)
@SpringBootApplication
public class BazDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazDigitalApplication.class, args);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
	}

}