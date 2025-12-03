package com.embarkx.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Card service REST API Documentation",
                description = "Card microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Mordinia Mordinia",
                        email = "mordinia@mordinia.com",
                        url = "mordinia.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.mordinia.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Card Microservice REST API Documentation",
                url = "https://www.mordinia.com/swagger-ui.html"
        )
)
public class CardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }

}
