package com.jwt.controller.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jwt.service.CartService;

@Controller
@RequestMapping(value = "/customer/cartItem")
public class CartItemController {

	@Autowired
	private CartService cartService;

	@RequestMapping(method = RequestMethod.POST)
	public String ProductDetailsPost(Model model, @RequestParam("counter") int counter,
			@RequestParam("productId") String id, HttpServletRequest request) {

		cartService.EditCart(counter, Integer.parseInt(id));
		return "redirect:/customer/cart";
	}

}
