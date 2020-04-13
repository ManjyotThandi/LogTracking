package com.test.logfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.test.repository")
@ComponentScan(basePackages= {"com.test"})
@EntityScan("com.test.models")
public class LogFilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogFilesApplication.class, args);
	}

}
