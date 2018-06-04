package com.jwt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.dao.CartDao;
import com.jwt.model.Cart;
import com.jwt.model.CartItem;
import com.jwt.model.Customer;
import com.jwt.model.Product;
import com.jwt.service.CategoryService;
import com.jwt.service.CustomerService;
import com.jwt.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String Products(ModelAndView model, Model models) {

		models.addAttribute("categories", categoryService.getAllCategories());
		List<Product> allProducts = productService.getAllProducts();
		if (allProducts != null) {
			models.addAttribute("products", allProducts);
		} else {
			System.out.println("It's Empty");
		}

		return "product";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String Product() {

		return "product";
	}

	@RequestMapping(value = "/product-detail/{id}", method = RequestMethod.GET)
	public String ProductDetails(Model model, @PathVariable("id") int id) {
		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "product-detail";
	}

	@RequestMapping(value = "/product-detail/{id}", method = RequestMethod.POST)
	public String ProductDetailsPost(
			/* @ModelAttribute("product") Product product, */ @PathVariable("id") int id, Model model,
			@RequestParam("counter") int counter, HttpServletRequest request) {

		cartDao.EditCart(counter, id);
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/ajax/filter", method = RequestMethod.GET)
	public ModelAndView filterProduct(ModelAndView model, @RequestParam("minPrice") float minPrice, 
			@RequestParam("maxPrice") float maxPrice) {
		
		model.addObject("products", productService.filterProductsByPrice(minPrice, maxPrice));
		model.setViewName("products_list");
		
		return model;
	}
	
	@RequestMapping(value = "/ajax/filterByName", method = RequestMethod.GET)
	public ModelAndView filterByName(ModelAndView model, @RequestParam("name") String name) {
		
		model.addObject("products", productService.filterProductsByName(name));
		model.setViewName("products_list");
		
		return model;
	}

}
