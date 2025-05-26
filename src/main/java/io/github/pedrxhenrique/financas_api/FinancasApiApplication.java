package io.github.pedrxhenrique.financas_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FinancasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancasApiApplication.class, args);
	}

}
