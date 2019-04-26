package io.conor.model;


public class Visa implements PaymentMethod {
	 
	  private final String name;
	  private final String cardNumber;
	  private final String expires;
	  private static Visa card;
	 
	  private Visa(String name, String cardNumber, String expires) {
	    this.name = name;
	    this.cardNumber = cardNumber;
	    this.expires = expires;
	    
	  }
	 
	  public static Visa getInstance(String name, String cardNumber, String expires)
	  {
		  if (card==null)
		  {
			  card= new Visa(name,cardNumber,expires);
			  
		  }
		  return card;
	  }
	  
	  @Override
	  public boolean pay(int price) {
	 
	    return true; // if payment goes through
	  }
	 
	}
