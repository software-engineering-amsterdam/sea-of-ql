package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Visitor;

public abstract class Type implements ASTNode {

	private final String type;

	public Type(String type) {
		this.type = type;
	}

	public String getTypeName() {
		return type;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
