package com.msynoradzki.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msynoradzki.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
