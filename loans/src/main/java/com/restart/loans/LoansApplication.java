package com.restart.loans;

import com.restart.loans.dto.LoansContactInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditor")
@OpenAPIDefinition(info=@Info(
		title="EazyBanks Loans_MS",
		description="Eazy Banks Loans Micro Services API documentation",
		version="v1",
		contact=@Contact(name = "Santhosh ",email="santhoshsk25420@gmail.com"),
		license = @License(name="Apache 2.0")))
@EnableConfigurationProperties(value = LoansContactInfo.class)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
