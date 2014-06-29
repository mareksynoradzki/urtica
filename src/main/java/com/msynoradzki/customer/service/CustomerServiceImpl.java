package com.msynoradzki.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.msynoradzki.customer.base.service.GenericServiceImpl;
import com.msynoradzki.customer.domain.Customer;
import com.msynoradzki.customer.repository.CustomerRepository;
import com.msynoradzki.customer.repository.Specification.CustomerSpecification;


@Service("customerService")
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public JpaRepository<Customer, Long> getRepository() {
		return customerRepository;
	}
	
	
	//Only to demonstrate 
	public List<Customer> findByName(String name){
		return customerRepository.findAll(CustomerSpecification.getCustomerFilterByNameSpecification(name));
	}


}
