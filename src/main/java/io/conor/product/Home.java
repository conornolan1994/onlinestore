package io.conor.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.conor.model.Product;
@Entity
public class Home extends Category {

	String categoryTypeTest;

	
	public Home(String categoryType) {
		super();
		this.categoryTypeTest = categoryType;
	}

//
//	@Override
//	   public void createCategory() {
//			Category category = new Home(categoryType);
//			//Product product = new Product(title, manufacturer, price, homeElectronic.getCategoryType(), image);
//	   }


	public String getCategoryType() {
		return categoryTypeTest;
	}


	public void setCategoryType(String categoryType) {
		this.categoryTypeTest = categoryType;
	}
}
