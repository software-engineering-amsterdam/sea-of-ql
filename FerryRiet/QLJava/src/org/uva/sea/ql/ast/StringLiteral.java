package org.uva.sea.ql.ast;

public class StringLiteral extends Expr {

	String value;

	public StringLiteral(String string) {
		value = string;
	}

	@Override
	public void eval() {

	}

}
