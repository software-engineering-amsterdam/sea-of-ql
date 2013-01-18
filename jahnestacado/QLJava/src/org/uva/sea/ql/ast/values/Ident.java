package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.Expr;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
