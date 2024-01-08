package com.malicia.mrg.customer.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.malicia.mrg.customer.domain.aggregate.Customer;
import com.malicia.mrg.customer.domain.service.CustomerService;

@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	private MeterRegistry metricsRegistry;

	@GetMapping("customer/{customerId}")
	public Customer getCustomer(@PathVariable Integer customerId) {
		logger.info("Inside CustomerController........");
		return customerService.getCustomerById(customerId);
	}

	@GetMapping("/messages")
	public String getMessage() {
		return "Hello from Docker!";
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("tag/{tagName}")
	public String setTagName(@PathVariable String tagName) {
		logger.info("Inside CustomerController........");

		Counter counter;
//			counter = metricsRegistry.get("metrics_test_tag").tag("tagname", tagName).counter();
		counter = metricsRegistry.find("metrics_test_tag").tag("tagname", tagName).counter();
		if (counter==null) {
			counter = Counter.builder("metrics_test_tag").tag("tagname", tagName).register(metricsRegistry);
		}
		counter.increment();
		return "Done" + tagName;
	}

}
