package io.conor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
	
	@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER)
	private List<Product> products;


	public ShoppingCart(int id, List<Product> products) {
		super();
		this.id = id;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shopping_cart_id")
	private int id;
	 
	  
	 
	  public ShoppingCart() {
	    products = new ArrayList<Product>();
	  }
	 
	  public void addProduct(Product product) {
	 
	    products.add(product);
	  }
	 
	  public List<Product> getProducts() {
		return products;
	}

	public double calcTotalCost() {
	 
	    double total = 0.0;
	    for (Product product : products) {
	 
	total += product.getPrice();
	    }
	 
	    return total;
	  }
	 
	  public boolean pay(PaymentMethod method) {
	 
	    double totalCost = calcTotalCost();
	    return method.pay(totalCost);
	  }
	}