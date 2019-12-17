package com.savingaccount.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SavingAccountMicroserviceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavingAccountMicroserviceApiApplication.class, args);
	}

}
