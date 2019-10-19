package com.example.demo.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.biz.service.CustomerService;
import com.example.demo.biz.service.DataNotFounfException;
import com.example.demo.biz.service.domain.Customer;

@Controller
@RequestMapping("/customer/{customerId}")
@SessionAttributes(value="editCustomer")
public class CustomerEditController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	CustomerService customerService;

	@RequestMapping(path="/edit",method = RequestMethod.GET)
	public String redirectToEntryForm(@PathVariable int customerId,Model model) throws DataNotFounfException{
		Customer customer = customerService.findById(customerId);
		model.addAttribute("editCustomer", customer);
		return "redirect:enter";
	}

	@RequestMapping(path="/enter",method = RequestMethod.GET)
	public String showEntryForm() {
		return "customer/edit/enter";
	}

	@RequestMapping(path="enter",params = "_event_proceed",method = RequestMethod.POST)
	public String verify(@Valid @ModelAttribute("editCustomer") Customer customer, Errors errors) {
		if(errors.hasErrors()) {
			System.out.println(errors.getAllErrors());

			return "customer/edit/enter";
		}
		return "redirect:review";
	}

	@RequestMapping(path="/review",method = RequestMethod.GET)
	public String showReview() {
		return "customer/edit/review";
	}

	@RequestMapping(path="/review", params = "_event_confirmed",method = RequestMethod.POST)
	public String edit(@ModelAttribute("editCustomer") Customer customer) throws DataNotFounfException{
		customerService.update(customer);
		return "redirect:edited";
	}

	@RequestMapping(path="/edited",method = RequestMethod.GET)
	public String showEdited(SessionStatus sessionStatus) {
		sessionStatus.setComplete();

		return "customer/edit/edited";
	}
}
