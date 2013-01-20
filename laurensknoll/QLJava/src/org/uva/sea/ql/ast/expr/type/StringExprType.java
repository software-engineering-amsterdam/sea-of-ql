package org.uva.sea.ql.ast.expr.type;

public class StringExprType extends AbstractExprType {

	private final String value;

	public StringExprType(String value) {
		this.value = value;
	}

	public String getName() {
		return value;
	}

}
