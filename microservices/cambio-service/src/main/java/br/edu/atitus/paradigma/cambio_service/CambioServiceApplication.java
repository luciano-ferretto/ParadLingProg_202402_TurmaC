package br.edu.atitus.paradigma.cambio_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class CambioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CambioServiceApplication.class, args);
	}

}
