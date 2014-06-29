package com.msynoradzki.customer.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.msynoradzki.customer.domain.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		validateChief(target, errors);

	}

	//TODO correct this method
	private void validateChief(Object target, Errors errors){
		Customer customer = (Customer)target;
		System.out.println(customer +" validateChief");
		if(customer.getChief()==null || (customer.getChief()!=null && customer.getChief().getId()==null))
			errors.rejectValue("chief.id", "validation.emptyChief");
	}
}
