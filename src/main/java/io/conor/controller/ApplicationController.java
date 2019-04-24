package io.conor.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.conor.model.PaymentMethod;
import io.conor.model.Product;
import io.conor.model.User;
import io.conor.service.ProductService;
import io.conor.service.ShoppingCartService;
import io.conor.service.UserService;

@Controller
public class ApplicationController {
	
	private ArrayList<Product> shoppingCart = new ArrayList<Product>();
	
	
	private int totalPrice;
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String getCart(HttpServletRequest request)
	{
		
		
		for (int i = 0; i < shoppingCart.size();i++)
		{
			totalPrice = totalPrice + shoppingCart.get(i).getPrice();
		}
		
		request.setAttribute("shoppingCart", shoppingCart);
		request.setAttribute("totalPrice", totalPrice);
		totalPrice = 0;
		request.setAttribute("mode","MODE_SHOPPING_CART");
		
		
		return "welcome";
		
	}
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String openCart(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Product newProduct = productService.getProductById(id);
		shoppingCart.add(newProduct);
		if (newProduct.getId()==(productService.getProductById(id).getId()))
		{
			productService.getProductById(id).setStockLevel(productService.getProductById(id).getStockLevel()-1);
		}
		
		for (int i = 0; i < shoppingCart.size();i++)
		{
			if (newProduct.getId()==(productService.getProductById(id).getId()))
			{
				productService.getProductById(id).setStockLevel(productService.getProductById(id).getStockLevel()-1);
				break;
			}
			continue;
		
		}
		
		for (int i = 0; i < shoppingCart.size();i++)
		{
			totalPrice = totalPrice + shoppingCart.get(i).getPrice();
		}
		
		request.setAttribute("shoppingCart", shoppingCart);
		request.setAttribute("totalPrice", totalPrice);
		totalPrice = 0;
		request.setAttribute("mode","MODE_SHOPPING_CART");
		
		
		return "welcome";
		
		
	}
	
	
	
	@RequestMapping(value ="/removeFromCart",method = RequestMethod.POST)
	public String removeFromCart(HttpServletRequest request)
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		Product newProduct = productService.getProductById(id);
		shoppingCart.remove(newProduct);
		
		newProduct.setStockLevel(newProduct.getStockLevel()+1);
		for (int i = 0; i < shoppingCart.size();i++) {
			if (shoppingCart.get(i).getId()==newProduct.getId())
				{
					productService.getProductById(id).setStockLevel(productService.getProductById(id).getStockLevel()+1);
					shoppingCart.remove(shoppingCart.get(i));
					break;
				}
			
			
		}
		totalPrice=0;
		for (int i = 0; i < shoppingCart.size();i++)
		{
			totalPrice = totalPrice + shoppingCart.get(i).getPrice();
		}
		
		request.setAttribute("shoppingCart", shoppingCart);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("mode","MODE_SHOPPING_CART");
		
		
		return "welcome";
		

	}
	
	@RequestMapping("/purchase")
	public String purchaseCart(@SessionAttribute("user") User user,@RequestParam int price, HttpServletRequest request)
	{
		
		for (int i = 0; i < shoppingCart.size();i++)
		{
			totalPrice = totalPrice + shoppingCart.get(i).getPrice();
		}
		request.setAttribute("user", user);
		
		request.setAttribute("shoppingCart", shoppingCart);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("mode","MODE_PAYMENT");
		
		
		return "paymentpage";
	}
	
	
	@RequestMapping("/")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "userpage";
	}
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode","MODE_REGISTER");
		return"welcome";
		
	}
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request) {
		
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return"welcome";
	}
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return"adminpage";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcome";
	}
	
	@GetMapping("/info")
	   public String userInfo(@SessionAttribute("user") User user) {

	      System.out.println("Email: " + user.getEmail());
	      System.out.println("First Name: " + user.getUsername());

	      return "user";
	   }
	
	@RequestMapping ("/login-user")
	public String loginUser(HttpSession session,@ModelAttribute("user") User user, HttpServletRequest request) {
		if(userService.findByEmailAndPassword(user.getEmail(), user.getPassword())!=null) {
			addUserToSession(user, session);
			return "welcome";
		}
		else if (user.getEmail().equals("admin") && user.getPassword().equals("admin123"))
		{
			return "adminpage";
		}
		else {
			request.setAttribute("error", "Invalid Email or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcome";
			
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		shoppingCart = null;
		request.setAttribute("mode", "MODE_HOME");
		return "userpage";
	}
 
	
	private void addUserToSession(User user, HttpSession session) {
		session.setAttribute("user", user);
		
	}
 
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,HttpServletRequest request) {
		userService.deleteTheUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS"); 
		return "welcome";
	}
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode","MODE_UPDATE"); 
		return "welcome";
	}
	
	@RequestMapping("/delete-product")
	public String deleteProduct(@RequestParam int id,HttpServletRequest request) {
		productService.deleteTheProduct(id);
		request.setAttribute("products", productService.showAllProducts());
		request.setAttribute("mode","ALL_PRODUCTS"); 
		return "adminpage";
	}
	@RequestMapping("/edit-product")
	public String editProduct(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("product", productService.editProduct(id));
		request.setAttribute("mode","MODE_PRODUCT_UPDATE"); 
		return "adminpage";
	}
	
	@GetMapping("/show-products")
	public String showAllProducts(HttpServletRequest request) {
		request.setAttribute("products", productService.showAllProducts());
		request.setAttribute("mode","ALL_PRODUCTS");
		return"adminpage";
	}
	
	@GetMapping("/products")
	public String showAllCustomerProducts(HttpServletRequest request) {
		request.setAttribute("products", productService.showAllProducts());
		request.setAttribute("mode","ALL_PRODUCTS_CUSTOMER");
		return"welcome";
	}
	
	
	@RequestMapping("/add-product")
	public String addProduct(HttpServletRequest request) {
		
		request.setAttribute("mode", "MODE_ADD_PRODUCT");
		return"adminpage";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute Product product,BindingResult bindingResult,HttpServletRequest request) {
		
		productService.saveMyProduct(product);
		request.setAttribute("mode", "MODE_HOME");
		return"adminpage";
	}
	
	
	


	

}
