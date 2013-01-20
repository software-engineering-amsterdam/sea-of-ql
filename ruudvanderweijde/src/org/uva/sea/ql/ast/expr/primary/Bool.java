package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.ast.expr.Expr;


public class Bool extends Expr {

	private final boolean bool;

	public Bool(boolean value) {
		this.bool = value;
	}
	
	public boolean getValue() {
		return bool;
	}

}
