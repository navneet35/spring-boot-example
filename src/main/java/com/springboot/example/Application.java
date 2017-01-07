package com.springboot.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    public static void main(final String[] args) {
    	LOGGER.debug("In main application");
        SpringApplication.run(Application.class, args);
    }
}
