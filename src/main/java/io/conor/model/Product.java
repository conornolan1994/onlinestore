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

import io.conor.category.Category;
import io.conor.category.CategoryFactory;

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
	

	



	public Product(String title, String manufacturer, int price, String category,int stockLevel, String image) {
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









	public int getStockLevel() {
		return stockLevel;
	}









	public Integer getId() {
		return id;
	}









	public String getTitle() {
		return title;
	}







	public String getManufacturer() {
		return manufacturer;
	}








	public int getPrice() {
		return price;
	}







	public String getCategory() {
		return category;
	}






	public void setId(int id) {
		this.id = id;
	}






	public void setTitle(String title) {
		this.title = title;
	}






	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}






	public void setPrice(int price) {
		this.price = price;
	}






	public void setCategory(String category) {
		this.category = category;
	}






	public void setImage(String image) {
		this.image = image;
	}






	public void setStockLevel(Integer stockLevel) {
		this.stockLevel = stockLevel;
	}





	
	
//	public static class ProductBuilder {
//		
//		private int id;
//		private String title;
//		private String manufacturer;
//		private int price;
//		private String category;
//		private String image;
//
//
//		private int stockLevel;
//		
//		public ProductBuilder()
//		{
//			
//		}
//		
//		
//
//
//		
//		
//		
//
//
//
//
//		public ProductBuilder setId(int id) {
//			this.id = id;
//			return this;
//		}
//
//
//
//
//
//
//
//
//		public ProductBuilder setTitle(String title) {
//			this.title = title;
//			return this;
//		}
//
//
//
//
//
//
//
//		public ProductBuilder setManufacturer(String manufacturer) {
//			this.manufacturer = manufacturer;
//			return this;
//		}
//
//
//
//
//
//
//		public ProductBuilder setPrice(int price) {
//			this.price = price;
//			return this;
//		}
//
//
//
//
//
//
//
//
//
//		public ProductBuilder setCategory(String category) {
//			this.category = category;
//			return this;
//		}
//
//
//
//
//
//
//
//
//
//		public ProductBuilder setImage(String image) {
//			this.image = image;
//			return this;
//		}
//
//
//
//
//
//
//		public ProductBuilder setStockLevel(int stockLevel) {
//			this.stockLevel = stockLevel;
//			return this;
//		}
//
//
//		
//
//
//
//		public ProductBuilder(String title, String manufacturer, int price, String category,int stockLevel, String image) {
//			super();
//			this.title = title;
//			this.manufacturer = manufacturer;
//			this.price = price;
//			this.category = category;
//			this.image = image;
//		}
//		
//		public Product build() {
//	        return new Product(title, manufacturer,price, category,stockLevel,image);
//	    }
//
//
//
//	}
//	

}
