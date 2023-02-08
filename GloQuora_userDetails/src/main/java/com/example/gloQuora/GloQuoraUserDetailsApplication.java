package com.example.gloQuora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GloQuoraUserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GloQuoraUserDetailsApplication.class, args);
	}

}
