package io.conor.model;

import java.util.Date;

public class MasterCard implements PaymentMethod {
	 
	  private final String name;
	  private final String cardNumber;
	  private final String expires;
	 
	  public MasterCard(String name, String cardNumber, String expires) {
	    super();
	    this.name = name;
	    this.cardNumber = cardNumber;
	    this.expires = expires;
	  }
	 
	  @Override
	  public boolean pay(int totalPrice) {
	 
	    return true; // if payment goes through
	  }
	 
	}
