package io.conor.visitor;

public interface ProductElement {

	public int accept(ShoppingCartVisitor visitor);
}
