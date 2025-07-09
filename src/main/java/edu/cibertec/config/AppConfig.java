package edu.cibertec.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.cibertec"})
@EntityScan(basePackages = {"edu.cibertec.entity"})
@EnableJpaRepositories(basePackages = {"edu.cibertec.repository"})
public class AppConfig {
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}
