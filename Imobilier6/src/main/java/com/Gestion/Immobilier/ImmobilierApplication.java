package com.Gestion.Immobilier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.Gestion.Immobilier")
public class ImmobilierApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmobilierApplication.class, args);
	}

}