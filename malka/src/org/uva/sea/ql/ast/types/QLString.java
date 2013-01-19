package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;

public class QLString extends Expr {
	private final String value;
	
	public QLString(String str) {
		this.value = str;
	}
	
	public String getValue() {
		return this.value;
	}
}
