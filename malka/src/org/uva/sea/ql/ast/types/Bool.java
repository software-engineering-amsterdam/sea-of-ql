package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;

public class Bool extends Expr {
	
	private final boolean value;
	
	public Bool(boolean bool) {
		this.value = bool;
	}

	public boolean getValue() {
		return this.value;
	}
	
}
