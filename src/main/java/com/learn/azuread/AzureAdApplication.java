package com.learn.azuread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity
@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AzureAdApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureAdApplication.class, args);
	}

}
