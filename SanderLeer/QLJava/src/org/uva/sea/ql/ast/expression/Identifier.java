package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Visitor;

public class Identifier extends Expression {
	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
