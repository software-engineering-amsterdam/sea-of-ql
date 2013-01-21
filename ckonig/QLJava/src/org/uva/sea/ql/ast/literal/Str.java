package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expr;

public class Str extends Expr {
	private final String value;

	public Str(String s) {
		this.value = s.replace("\"", "");
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
