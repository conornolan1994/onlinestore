package io.conor.repository;

import org.springframework.data.repository.CrudRepository;

import io.conor.model.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
	public Product findByCategory(String category);
	public Product findByManufacturer(String manufacturer);
	public Product findByTitle(String title);
}
