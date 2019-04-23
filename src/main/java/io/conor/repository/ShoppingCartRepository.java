package io.conor.repository;

import org.springframework.data.repository.CrudRepository;

import io.conor.model.Product;
import io.conor.model.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Integer> {
	

}
