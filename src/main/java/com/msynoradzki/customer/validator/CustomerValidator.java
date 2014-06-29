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
		Customer customer = (Customer)target;
		validateNotEmptyChief(customer, errors);
		validateCustomerAndChiefNotEqual(customer, errors);

	}

	private void validateNotEmptyChief(Customer customer, Errors errors){
		if(customer.getChief()==null || (customer.getChief()!=null && customer.getChief().getId()==null))
			errors.rejectValue("chief", "validation.emptyChief");
	}
	
	private void validateCustomerAndChiefNotEqual(Customer customer, Errors errors){
		Customer chief = customer.getChief();
		
		if(chief!=null && customer.getId().equals(chief.getId())){
			errors.rejectValue("chief", "validation.chiefAndCustomerEqual");
		}
	}
}

