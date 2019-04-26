package io.conor.payment;

public class MasterCard implements PaymentMethod {
	 
	  private final String name;
	  private final String cardNumber;
	  private final String expires;
	  private static MasterCard card;
	 
	  private MasterCard(String name, String cardNumber, String expires) {
	    this.name = name;
	    this.cardNumber = cardNumber;
	    this.expires = expires;
	  }
	 
	  public static MasterCard getInstance(String name, String cardNumber, String expires)
	  {
		  if (card==null)
		  {
			  card= new MasterCard(name,cardNumber,expires);
			  
		  }
		  return card;
	  }
	  
	  @Override
	  public boolean pay(int totalPrice) {
	 
	    return true; // if payment goes through
	  }
	 
	}
