package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl") // Enable JPA Auditing and refer to the AuditorAware bean
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts API",
                version = "1.0",
                description = "API for Managing Accounts",
                contact = @Contact(name = "ff", email = "aaa@a.pl", url = "https://eazybytes.com"),
				license = @License(name = "Apache 2.0", url = "http://springdoc.org")
        ),
		externalDocs = @ExternalDocumentation(
				description = "Accounts API Documentation",
				url = "https://eazybytes.com"
		)
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }
}