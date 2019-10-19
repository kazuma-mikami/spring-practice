package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.biz.service.CustomerService;
import com.example.demo.biz.service.DataNotFounfException;
import com.example.demo.biz.service.domain.Customer;

@Controller
public class CustomerListController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	CustomerService customerService;

	@RequestMapping(path = "/customer", method = RequestMethod.GET)
	public String showAllCustomers(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customer/list";
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "forward:/customer";
	}

	@RequestMapping(path = "/customer/{customerId}", method = RequestMethod.GET)
	public String showAllCustomerDetail(@PathVariable int customerId, Model model) throws DataNotFounfException {
		Customer customer = customerService.findById(customerId);
		model.addAttribute("customer", customer);
		return "customer/detail";
	}
}
