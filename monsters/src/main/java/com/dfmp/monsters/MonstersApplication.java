package com.dfmp.monsters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MonstersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonstersApplication.class, args);
	}

}
