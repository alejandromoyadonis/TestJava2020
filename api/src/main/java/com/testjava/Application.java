package com.testjava;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	private PriceLoader loader;

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) {
		this.loader.run();
	}
}