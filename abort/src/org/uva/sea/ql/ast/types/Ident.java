package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

public class Ident extends Node {
	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(final IVisitor visitor) {
		visitor.visit(this);
	}
}
