package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.Expr;

public class BoolLit extends Expr{
	private final String value;

	public BoolLit(String value) {
		this.value = value;
		

	}
	
	public String getValue() {
		return value;
	}

}
