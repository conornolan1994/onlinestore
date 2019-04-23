package io.conor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.conor.model.Product;
import io.conor.model.ShoppingCart;
import io.conor.repository.ProductRepository;
import io.conor.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	
	public List<ShoppingCart>showAllProducts(){
		
		List<ShoppingCart> products = new ArrayList<>();
		shoppingCartRepository.findAll()
		.forEach(products::add);
		return products;
	}
	
	



	public void addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepository.save(shoppingCart);
		
	}


	public void updateShoppingCart(int id, ShoppingCart shoppingCart) {
		shoppingCartRepository.save(shoppingCart);
		
	}


	public void deleteTheShoppingCart(int id) {
	
		shoppingCartRepository.delete(id);
	}
	
	public void saveMyShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepository.save(shoppingCart);
	}
	public ShoppingCart editShoppingCart(int id) {
		
		return shoppingCartRepository.findOne(id);
	}
	
	

}
