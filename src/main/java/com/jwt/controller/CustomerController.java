package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwt.model.Cart;
import com.jwt.model.CartItem;
import com.jwt.model.Customer;
import com.jwt.model.Orders;
import com.jwt.service.CustomerService;
import com.jwt.service.OrderService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String customerPage() {
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value="error", required = false) String error, 
			@RequestParam(value="logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "username or password is wrong.");
		}
		
		if (logout != null) {
			model.addAttribute("msg", "you have to logout.");
		}
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String adminLogout() {
		
		return "redirect:/j_spring_security_logout";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		model.addObject("customer", new Customer());
		model.setViewName("registeration");
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Customer customer, Model model) {
		
		customerService.AddCustomer(customer);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String Order(Model models, @ModelAttribute("orderss") final Orders orderss,
			final RedirectAttributes redirectAttributes) {

		models.addAttribute("order1", orderss);

		List<CartItem> cartItems = orderss.getCart().getCartItemList();
		float sum = 0;
		for (CartItem cartItem : cartItems) {

			sum = sum + (cartItem.getProduct().getPrice() * cartItem.getQuantity());
		}
		models.addAttribute("cartItemss", cartItems);
		models.addAttribute("sum", sum);

		// for(int i=0;i<orderss)

		return "order";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String Cart(Model models) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		Customer customUser = customerService.getCustomerByName(user.getUsername());
		Cart carts = customUser.getCart();

		List<CartItem> cartItemses = carts.getCartItemList();
		models.addAttribute("cartItemss", cartItemses);
		return "cart";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String CartPost(@ModelAttribute Cart cart, Model models, @RequestParam("address") String address,
			final RedirectAttributes redirectAttributes) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		Customer customUser = customerService.getCustomerByName(user.getUsername());
		Cart carts = customUser.getCart();

		Orders order = new Orders();
		order.setAddress(address);
		order.setCart(carts);
		order.setCust(customUser);
		orderService.CreateOrder(order);
		redirectAttributes.addFlashAttribute("orderss", order);
		return "redirect:/order";
	}
	
}
