package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.*;

public class Str extends Expr {
	private final String value;

	public Str(String s) {
		this.value = s;
	}
	
	public String getValue() {
		return value;
	}
}
