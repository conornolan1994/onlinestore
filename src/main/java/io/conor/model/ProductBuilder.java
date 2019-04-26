//package io.conor.model;
//
//import javax.persistence.Column;
//
//
//
////@OneToOne(cascade = {CascadeType.ALL})
////private Category category;
//
//
//public class ProductBuilder {
//	
//	private int id;
//	private String title;
//	private String manufacturer;
//	private int price;
//	private String category;
//	private String image;
//
//
//	private Integer stockLevel;
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
//	public ProductBuilder setId(int id) {
//		this.id = id;
//		return this;
//	}
//
//
//
//
//
//
//
//
//	public ProductBuilder setTitle(String title) {
//		this.title = title;
//		return this;
//	}
//
//
//
//
//
//
//
//	public ProductBuilder setManufacturer(String manufacturer) {
//		this.manufacturer = manufacturer;
//		return this;
//	}
//
//
//
//
//
//
//	public ProductBuilder setPrice(int price) {
//		this.price = price;
//		return this;
//	}
//
//
//
//
//
//
//
//
//
//	public ProductBuilder setCategory(String category) {
//		this.category = category;
//		return this;
//	}
//
//
//
//
//
//
//
//
//
//	public ProductBuilder setImage(String image) {
//		this.image = image;
//		return this;
//	}
//
//
//
//
//
//
//	public ProductBuilder setStockLevel(Integer stockLevel) {
//		this.stockLevel = stockLevel;
//		return this;
//	}
//
//
//	
//
//
//
//	public ProductBuilder(String title, String manufacturer, int price, String category,Integer stockLevel, String image) {
//		super();
//		this.title = title;
//		this.manufacturer = manufacturer;
//		this.price = price;
//		this.category = category;
//		this.image = image;
//	}
//	
//	public ProductBuilder() {
//		// TODO Auto-generated constructor stub
//	}
//
//
//
//
//
//
//
//
//	public Product build() {
//        return new Product(title, manufacturer,price, category,stockLevel,image);
//    }
//
//}
