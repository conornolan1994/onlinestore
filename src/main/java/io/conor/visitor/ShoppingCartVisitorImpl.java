package io.conor.visitor;

import io.conor.model.Product;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	@Override
	public int visit(Product product) {
		int cost=0;
		//apply 5$ discount if book price is greater than 50
		if(product.getPrice() > 200)
		{
			cost = product.getPrice()-15;
		}
		else
		{
			cost = product.getPrice();
		}
		return cost;
	}


}
