package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Value interpret() {
		return new org.uva.sea.ql.ast.type.StringType(getName());
	}

}
