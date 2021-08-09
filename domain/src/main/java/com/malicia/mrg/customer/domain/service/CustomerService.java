package com.malicia.mrg.customer.domain.service;

import com.malicia.mrg.customer.domain.aggregate.Customer;

public interface CustomerService {

	public Customer getCustomerById(Integer customerId);

}
