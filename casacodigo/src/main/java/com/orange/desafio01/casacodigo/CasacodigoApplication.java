package com.orange.desafio01.casacodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CasacodigoApplication {
	// java project commit to chance branch
	public static void main(String[] args) {
		SpringApplication.run(CasacodigoApplication.class, args);
	}
}
