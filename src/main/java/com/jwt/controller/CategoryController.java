package com.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jwt.service.CategoryService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryService CategoryService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getCategory(Model model, @PathVariable("id") int id) {
		model.addAttribute("category", CategoryService.getCategoryById(id)) ;
		return "category";
	}
	
}
