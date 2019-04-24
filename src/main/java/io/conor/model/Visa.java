package io.conor.model;

import java.sql.Date;

public class Visa implements PaymentMethod {
	 
	  private final String name;
	  private final String cardNumber;
	  private final Date expires;
	 
	  public Visa(String name, String cardNumber, Date expires) {
	    super();
	    this.name = name;
	    this.cardNumber = cardNumber;
	    this.expires = expires;
	  }
	 
	  @Override
	  public boolean pay(int price) {
	 
	    return true; // if payment goes through
	  }
	 
	}
