package com.malicia.mrg.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication {

	private static final Logger logger = LoggerFactory.getLogger(CustomerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
		logger.trace("---==[ trace  ]==---");
		logger.debug("---==[ debug ]==---");
		logger.info("---==[  info   ]==---");
		logger.warn("---==[  warn   ]==---");
		logger.error("---==[ error  ]==---");
		logger.info("Start");

		logger.info("CustomerApplication Started........");
	}

}
