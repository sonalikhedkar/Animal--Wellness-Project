package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.app.*" })
@SpringBootApplication
public class EComBackend13Application {

	public static void main(String[] args) {
		SpringApplication.run(EComBackend13Application.class, args);
	}
}
