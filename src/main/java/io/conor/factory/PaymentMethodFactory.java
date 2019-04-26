package io.conor.factory;

import io.conor.payment.MasterCard;
import io.conor.payment.PaymentMethod;
import io.conor.payment.Visa;

public class PaymentMethodFactory {

	public static PaymentMethod getPaymentMethod(String paymentMethod, String cardName, String cardNum, String expDate) {
		
		PaymentMethod pm = null;
		
		if (paymentMethod.equals("Visa")) {
        pm = Visa.getInstance(cardName,cardNum,expDate);
	        
	    } 
	    else if (paymentMethod.equals("MasterCard")) {
	      pm = MasterCard.getInstance(cardName,cardNum,expDate);
	            
	            
	    }
	    else
	    {
	    	pm = null;
	    }
	          return pm;
	}


}
