package io.conor.model;

import io.conor.visitor.ShoppingCartVisitor;

public interface ProductElement {

	public int accept(ShoppingCartVisitor visitor);
}
