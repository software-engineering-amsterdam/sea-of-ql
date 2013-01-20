package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public class Literal extends AbstractExpr {

	private final String name;

	public Literal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
