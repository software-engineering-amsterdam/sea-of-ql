package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.exp.Expression;

public class Identifier extends Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
