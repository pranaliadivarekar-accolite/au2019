package com.accolite.au;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.accolite.au"
    })
@EnableAutoConfiguration
public class Assignment2AugustAmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2AugustAmApplication.class, args);
	}

}
