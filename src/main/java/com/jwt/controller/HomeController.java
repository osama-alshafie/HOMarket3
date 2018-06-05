package com.jwt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Customer;
import com.jwt.service.CustomerService;
import com.jwt.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Customer customer = new Customer();
		model.addObject("customer", customer);
		model.setViewName("registeration");
		return model;
	}

	@RequestMapping(value = "/registeration", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute Customer customer, BindingResult br, Model model) {

		if (br.hasErrors()) {
			return "registeration";
		}

		customerService.AddCustomer(customer);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(Model model) {
		model.addAttribute("title", "Home Page");
		model.addAttribute("products", productService.getAllProducts());
		return "home-02";
	}
	
	@RequestMapping("/login")
	public String login() {

		return "login";
	}
	
}
