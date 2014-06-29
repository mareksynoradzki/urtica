package com.msynoradzki.customer.contoller.customer.crud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.msynoradzki.customer.domain.Customer;
import com.msynoradzki.customer.service.CustomerService;
import com.msynoradzki.customer.utils.ApplicationConstants;
import com.msynoradzki.customer.validator.CustomerValidator;

@Controller
@RequestMapping(value = "/customer")
@SessionAttributes("entity")
public class CustomerCRUDController {

	@Autowired
	private CustomerService customerService;
	
    @Autowired
    private CustomerValidator customerValidator;

	@RequestMapping(value = (ApplicationConstants.READ_REQUEST_MAPPING + "/{id}"), method = RequestMethod.GET)
	public String read(@PathVariable Long id, Model model,
			HttpServletRequest request) {
		model.addAttribute("entity", customerService.findById(id));
		return "/" + ApplicationConstants.DETAILS_VIEW_CATALOGUE
				+ "/customer-success";
	}

	@RequestMapping(value = (ApplicationConstants.DELETE_REQUEST_MAPPING + "/{id}"), method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model,
			HttpSession session, RedirectAttributes attributes,
			HttpServletRequest request) {
		customerService.delete(id);
		return "redirect:/" + getViewName(request) + "/list";
	}
	
    @RequestMapping(value = ApplicationConstants.CREATE_REQUEST_MAPPING, method = RequestMethod.GET)
    public String getCreateView(Model model, HttpServletRequest request, HttpSession session) {
    	Customer customer = new Customer();
    	model.addAttribute("entity", customer);
    	model.addAttribute("chiefList", prepareChiefList());
    	return "/" + ApplicationConstants.CREATE_VIEW_CATALOGUE+ "/customer-success";
    }

	@RequestMapping(value = ApplicationConstants.CREATE_REQUEST_MAPPING, method = RequestMethod.POST)
    public String create(@ModelAttribute("entity") @Valid Customer customer, BindingResult bindingResult, Model model,
            HttpServletRequest request, RedirectAttributes attributes, HttpSession session) {
    	customerService.save(customer);
    	return "redirect:/" + getViewName(request) + "/list";
    }
    
    @RequestMapping(value = (ApplicationConstants.UPDATE_REQUEST_MAPPING + "/{id}"), method = RequestMethod.GET)
    public String getUpdateView(@PathVariable Long id, Model model, HttpServletRequest request) {
            Customer customerToUpdate = customerService.findById(id);
            model.addAttribute("chiefList", prepareChiefList());
            model.addAttribute("entity", customerToUpdate);
        return "/" + ApplicationConstants.UPDATE_VIEW_CATALOGUE+ "/customer-success";
    }
    
    @RequestMapping(value = (ApplicationConstants.UPDATE_REQUEST_MAPPING + "/{id}"), method = RequestMethod.POST)
    public String update(@ModelAttribute("entity") @Valid Customer customer, BindingResult bindingResult, @PathVariable Long id, Model model,HttpSession session, RedirectAttributes attributes, HttpServletRequest request) {
    	customerValidator.validate(customer, bindingResult);
    	if(bindingResult.hasErrors()){
    		 model.addAttribute("chiefList", prepareChiefList());
    		 return "/" + ApplicationConstants.UPDATE_VIEW_CATALOGUE+ "/customer-success";
    	}
    	customerService.save(customer);
        return "redirect:/" + getViewName(request) + "/list";
    }
    
	protected String getViewName(HttpServletRequest request) {
		int endIndex = request.getServletPath().indexOf("/", 1);
		String path = request.getServletPath().substring(1, endIndex);
		return path;
	}
	

    private List<Customer> prepareChiefList() {
		return (List<Customer>) customerService.getAll();
	}
	
}
