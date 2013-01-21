package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expr;

public class StringLiteral extends Expr {
	private final String value;

	public StringLiteral(String s) {
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
