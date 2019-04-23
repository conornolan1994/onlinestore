package io.conor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import io.conor.model.Product;
import io.conor.model.ShoppingCart;
import io.conor.service.ProductService;
import io.conor.service.ShoppingCartService;

public class ShoppingCartController {

	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("/shoppingcart")
	public List<ShoppingCart> getShoppingCart() {
		return shoppingCartService.showAllProducts();
	}

}
