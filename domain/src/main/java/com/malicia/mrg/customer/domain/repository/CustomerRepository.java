package com.malicia.mrg.customer.domain.repository;

import com.malicia.mrg.customer.domain.aggregate.Customer;

public interface CustomerRepository {

	public Customer getCustomerById(Integer customerId);

}
