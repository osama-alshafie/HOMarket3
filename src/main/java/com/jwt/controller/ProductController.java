package com.jwt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

	@RequestMapping(value = "/productInventory", method = RequestMethod.GET)
	public String Products(ModelAndView model, Model models) {

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

}
