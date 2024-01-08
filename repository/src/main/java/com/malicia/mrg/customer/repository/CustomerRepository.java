package com.malicia.mrg.customer.repository;

import com.malicia.mrg.customer.domain.aggregate.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer,Long> {

	Customer findById(Integer id);

}
