package io.conor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	private double totalPrice;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@ManyToMany(targetEntity=Product.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set <Product> products = new HashSet<Product>();
	
	public UserOrder()
	{
		
	}
	
	public UserOrder(double totalPrice)
	{
		this.totalPrice=totalPrice;
	}

}
