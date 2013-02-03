package org.uva.sea.ql.ast.types;

import java.lang.String;

public class STRING extends Expr {

	private final String value;

	public STRING(String n) {
		this.value = n;
	}

	public String getValue() {
		return value;
	}
	
}
