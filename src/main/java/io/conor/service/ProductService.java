package io.conor.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.conor.model.Product;
import io.conor.model.User;
import io.conor.repository.ProductRepository;
import io.conor.repository.UserRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product>showAllProducts(){
		
		List<Product> product = new ArrayList<>();
		productRepository.findAll()
		.forEach(product::add);
		return product;
	}
	
	public Product getProductById(int id)
	{
		return productRepository.findOne(id);
	}
	
	



	public void addProduct(Product product) {
		productRepository.save(product);
		
	}


	public void updateProduct(int id, Product product) {
		productRepository.save(product);
		
	}


	public void deleteTheProduct(int id) {
	
		productRepository.delete(id);
	}
	
	public void saveMyProduct(Product product) {
		productRepository.save(product);
	}
	public Product editProduct(int id) {
		
		return productRepository.findOne(id);
	}
	
	public Product findByCategory(String category) {
		return productRepository.findByCategory(category);
	}
	
	public Product findByManufacturer(String manufacturer) {
		return productRepository.findByManufacturer(manufacturer);
	}
	
	public Product findByTitle(String title) {
		return productRepository.findByTitle(title);
	}
	
	

}