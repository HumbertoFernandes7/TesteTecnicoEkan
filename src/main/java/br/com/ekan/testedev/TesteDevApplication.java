package br.com.ekan.testedev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TesteDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteDevApplication.class, args);
	}

}
