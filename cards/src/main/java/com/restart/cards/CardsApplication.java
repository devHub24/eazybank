package com.restart.cards;

import com.restart.cards.dto.CardsContactInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Eazy Banks Cards",description = "REST API for EAZy Bank CARDS_MS",
contact = @Contact(name = "Santhosh", email = "santhoshsk25420@gmail.com"),
		version = "V1"
))
@EnableJpaAuditing(auditorAwareRef = "auditor")
@EnableConfigurationProperties(value = CardsContactInfo.class)
public class CardsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
