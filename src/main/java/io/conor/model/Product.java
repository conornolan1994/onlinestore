package io.conor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import io.conor.product.Category;
import io.conor.product.CategoryFactory;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int id;
	@Column(unique=true)
	private String title;
	@Column
	private String manufacturer;
	@Column
	private int price;
	@Column
	private String category;
	@Column
	private String image;
	@Column
	private Integer stockLevel;
//	@OneToOne(cascade = {CascadeType.ALL})
//	private Category category;
	






	public Product() {

	}
	

	



	public Product(String title, String manufacturer, int price, String category,Integer stockLevel, String image) {
		super();
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.image = image;
	}

	
	public String getImage() {
		return image;
	}





	public void setImage(String image) {
		this.image = image;
	}





	public int getStockLevel() {
		return stockLevel;
	}





	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}







	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getManufacturer() {
		return manufacturer;
	}





	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}





	public int getPrice() {
		return price;
	}





	public void setPrice(int price) {
		this.price = price;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}




	

}
