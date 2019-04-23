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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.conor.model.Product;
import io.conor.model.User;
import io.conor.service.ProductService;
import io.conor.service.UserService;

@Controller
public class ApplicationController {
	
	private ArrayList<Product> shoppingCart = new ArrayList<Product>();
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/cart")
	public String openCart(@RequestParam int id, HttpServletRequest request)
	{
		
		Product newProduct = productService.getProductById(id);
		shoppingCart.add(newProduct);
		
		newProduct.setStockLevel(newProduct.getStockLevel()-1);
		
		System.out.println(shoppingCart.size());
		for (int i = 0; i < shoppingCart.size();i++)
		{
			System.out.println(shoppingCart.get(0).getTitle());
		}
		//request.setAttribute("cart", productService.)
		request.setAttribute("mode","MODE_SHOPPING_CART");
		
		return "welcome";
	}
	
	@RequestMapping("/purchase")
	public String purchaseCart(@RequestParam int id, HttpServletRequest request)
	{
		return "welcome";
	}
	
	
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "welcome";
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
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByEmailAndPassword(user.getEmail(), user.getPassword())!=null) {
			return "userpage";
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
		request.setAttribute("mode", "MODE_HOME");
		return "welcome";
	}
 
	
	private void addUserToSession(User user, HttpSession session) {
		// TODO Auto-generated method stub
		
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
