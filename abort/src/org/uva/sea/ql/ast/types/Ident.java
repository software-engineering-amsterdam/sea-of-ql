package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.traversal.base.IVisitor;

/**
 * Identifier in the QL language, which is not instantiated unless a type could not be identified as another type in the grammar
 */
public class Ident extends Node {
	private final String name;

	public Ident(final String name) {
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
