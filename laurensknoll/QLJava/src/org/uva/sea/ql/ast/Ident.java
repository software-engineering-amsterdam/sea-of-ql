package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public class Ident extends AbstractExpr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
