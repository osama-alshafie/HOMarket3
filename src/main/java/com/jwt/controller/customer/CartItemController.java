package com.jwt.controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.jwt.model.Cart;
import com.jwt.model.CartItem;
import com.jwt.model.CustomCartItem;
import com.jwt.service.CartService;
import com.jwt.service.ProductService;

@Controller
@RequestMapping(value = "/customer/cartItem")
public class CartItemController {

	@Autowired
	private CartService cartService;

	// @Autowired
	// private ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	public String ProductDetailsPost(Model model, @RequestParam("counter") int counter,
			@RequestParam("productId") String id, HttpServletRequest request) {

		cartService.EditCart(counter, Integer.parseInt(id));
		return "redirect:/customer/cart";
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/add", method = RequestMethod.GET)
	public List<CustomCartItem> CartPostFromAjax(ModelAndView model, @RequestParam("id") int id) {

		List<CustomCartItem> customCartItem = new ArrayList<CustomCartItem>();
		

		cartService.EditCart(1, id);

		List<CartItem> CartItems = cartService.getCartByCustomer().getCartItemList();
		for (CartItem cartItem : CartItems) {
			if (cartItem.isDeleted() == false) {
				customCartItem.add(new CustomCartItem(cartItem.getProduct().getName(),
						cartItem.getQuantity() * cartItem.getProduct().getPrice()));
			}
		}

		return customCartItem;

	}
}
