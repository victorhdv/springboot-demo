package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class SpringBotRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBotRestApiApplication.class, args);
		System.out.println("Hello World!");
	}

}
