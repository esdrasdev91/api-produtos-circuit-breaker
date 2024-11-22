package com.esdrasdev.api_produtos_circuit_breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class ApiProdutosCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProdutosCircuitBreakerApplication.class, args);
	}

}
