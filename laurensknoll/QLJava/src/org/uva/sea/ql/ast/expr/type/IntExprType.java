package org.uva.sea.ql.ast.expr.type;

public class IntExprType extends AbstractExprType {

	private final int value;

	public IntExprType(int n) {
		this.value = n;
	}

	public int getValue() {
		return this.value;
	}

}
