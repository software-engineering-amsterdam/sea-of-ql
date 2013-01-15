package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
