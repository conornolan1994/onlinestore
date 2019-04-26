package io.conor.category;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TV extends Category {

	private String categoryType;

	
	public TV(String categoryType) {
		super();
		this.categoryType = categoryType;
	}

//
//	@Override
//	   public void createCategory() {
//			Category category = new Home(categoryType);
//	   }


	public String getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
}
