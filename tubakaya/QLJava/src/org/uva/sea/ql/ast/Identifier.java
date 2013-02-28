package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.Type;

public class Identifier extends Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	@Override
	public Type accept(ExpressionTypeVisitor visitor) {
		return visitor.visit(this);
	}
}