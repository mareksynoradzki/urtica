package com.msynoradzki.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.msynoradzki.customer.base.service.GenericServiceImpl;
import com.msynoradzki.customer.domain.Customer;
import com.msynoradzki.customer.repository.CustomerRepository;


@Service("customerService")
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public JpaRepository<Customer, Long> getRepository() {
		return customerRepository;
	}

}
