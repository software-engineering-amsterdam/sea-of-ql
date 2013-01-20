package org.uva.sea.ql.ast.expr.type;

public class BoolExprType extends AbstractExprType {

	private final boolean value;

	public BoolExprType(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return this.value;
	}

}
