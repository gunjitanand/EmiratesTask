package com.emirates.EmiratesTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emirates.controller.TaskController;

@SpringBootApplication
@ComponentScan(basePackageClasses = TaskController.class)
@EnableJpaRepositories("com.emirates.repository")
@EntityScan("com.emirates.entity")  
public class EmiratesTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmiratesTaskApplication.class, args);
	}
}
