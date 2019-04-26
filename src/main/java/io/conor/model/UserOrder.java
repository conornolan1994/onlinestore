package io.conor.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import io.conor.payment.PaymentMethod;

@Entity
public class UserOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	private double totalPrice;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToMany(targetEntity=Product.class, fetch=FetchType.EAGER)
	private Set <Product> products = new HashSet<Product>();
	
	public UserOrder()
	{
		
	}
	
	
	
	public UserOrder(User user, int totalPrice, Set<Product> products) {
		this.user = user;
		this.totalPrice=totalPrice;
		this.products = products;
	}

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

	
	public boolean pay(PaymentMethod method,int totalCost) {
        return method.pay(totalCost);
    }
	

}
