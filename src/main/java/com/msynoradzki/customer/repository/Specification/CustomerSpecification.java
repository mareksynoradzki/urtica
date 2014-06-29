package com.msynoradzki.customer.repository.Specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.google.common.collect.Lists;
import com.msynoradzki.customer.domain.Customer;

//TODO write test
public class CustomerSpecification {

	 public static Specification<Customer> getCustomerFilterByNameSpecification(final String name) {
		return new Specification<Customer>() {

			@Override
			public Predicate toPredicate(Root<Customer> root,
					CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicateList = Lists.newArrayList();
				
				predicateList.add(builder.equal(root.<String>get("name"), name));
				return builder.and(predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};
		 
	 }
}
