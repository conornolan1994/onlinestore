package io.conor.visitor;

import io.conor.model.Product;

public interface ShoppingCartVisitor {

	int visit(Product product);
}
