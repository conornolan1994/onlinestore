package io.conor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.conor.model.Product;
import io.conor.product.Category;
import io.conor.service.ProductService;



@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return productService.showAllProducts();
	}
	
	
	/*@RequestMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}*/
	
	@RequestMapping(method=RequestMethod.POST,value="/products")
	public void addProduct(@RequestBody Product product ) {
		productService.addProduct(product);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
	public void updateProduct(@RequestBody Product product,@PathVariable int id ) {
		productService.updateProduct(id,product);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteTheProduct(id);
	}
	
	@GetMapping("/saveProduct")
	public String saveProduct( @RequestParam String title, @RequestParam String manufacturer, @RequestParam int price, @RequestParam String category, @RequestParam int stockLevel, @RequestParam String image) {
		Product product= new Product(title,manufacturer,price,category, stockLevel, image);
		productService.saveMyProduct(product);
		return "Product saved";
	}

}
