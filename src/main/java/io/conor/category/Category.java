package io.conor.category;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize(as=Home.class)
public abstract class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	void createCategory();

}
