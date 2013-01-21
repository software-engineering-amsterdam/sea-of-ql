package org.uva.sea.ql.ast;

import java.util.HashMap;

public class StringLiteral extends Expr {

	private final String value;

	public StringLiteral(String string) {
		value = string;
	}

	public String getValue() {
		return value;
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new StringType();
	}
}
