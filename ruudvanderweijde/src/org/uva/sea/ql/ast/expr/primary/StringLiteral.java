package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.ast.expr.Expr;


public class StringLiteral extends Expr {

	private final String name;

	public StringLiteral(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
