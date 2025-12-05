package com.embarkx.loans;

import com.embarkx.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = "Bank Loans microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Mordinia Mordinia",
                        email = "mordinia@mordinia.com",
                        url = "https://www.mordinia.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.mordinia.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Bank Loans Microservice REST API Documentation",
                url = "https://www.mordinia.com/swagger-ui.html"
        )
)
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
