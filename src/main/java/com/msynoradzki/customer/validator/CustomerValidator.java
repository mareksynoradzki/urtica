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

	private void validateChief(Object target, Errors errors){
		Customer customer = (Customer)target;
		if(customer.getChief()==null)
			errors.rejectValue("chief", "validation.emptyChief");
	}
}
