package com.denireas.turion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TurionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurionApplication.class, args);
	}

}
