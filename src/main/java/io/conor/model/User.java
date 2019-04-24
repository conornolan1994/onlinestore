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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;




@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Email
	private String email;
	@Column(unique = true)
	private String username;
	@Size(min = 8)
	private String password;
	@Column
	private String shippingAddress;
	
	@OneToMany(targetEntity=UserOrder.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set <UserOrder> userOrders = new HashSet<UserOrder>();
	

	public User() {

	}
	public User(String email, String username, String password, String shippingAddress) {
		super();

		this.email = email;
		this.username = username;
		this.password = password;
		this.shippingAddress = shippingAddress;
		
	}



	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Set<UserOrder> getUserOrders() {
		return userOrders;
	}
	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	

}