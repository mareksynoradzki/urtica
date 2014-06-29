package com.msynoradzki.customer.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.msynoradzki.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer>  {

	//return all Customer base on name and pageable object
	Page<Customer> findByName(String name, Pageable pageable);
}
