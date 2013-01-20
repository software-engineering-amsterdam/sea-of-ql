package org.uva.sea.ql.ast.expr.type;

public class IdentExprType extends AbstractExprType {

	private final String value;

	public IdentExprType(String value) {
		this.value = value;
	}

	public String getName() {
		return value;
	}

}
