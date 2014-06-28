package com.msynoradzki.customer.contoller.customer.list;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msynoradzki.customer.service.CustomerService;

//TODO create GenericCrudAction
@Controller
@RequestMapping(value = "/customer")
public class CustomerListController {


	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("entities", customerService.getAll());
		return getViewName(request);
	}

	private String getViewName(HttpServletRequest request) {
		int endIndex = request.getServletPath().indexOf("/", 1);
		String path = request.getServletPath().substring(1, endIndex);
		return "/list/" + path + "-success";

	}
}