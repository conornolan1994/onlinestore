package io.conor.category;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Phone extends Category{

	private String categoryType;

	
	public Phone(String categoryType) {
		super();
		this.categoryType = categoryType;
	}

//
//	@Override
//	   public void createCategory() {
//			Category category = new Home(categoryType);
//			//Product product = new Product(title, manufacturer, price, homeElectronic.getCategoryType(), image);
//	   }


	public String getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

}
