package com.ajay.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBootExample {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExample.class, args);  
	}

}
//The line Started SpringBootExample in 14.047 seconds (JVM running for 17.391) in output window shows that our application is started.
