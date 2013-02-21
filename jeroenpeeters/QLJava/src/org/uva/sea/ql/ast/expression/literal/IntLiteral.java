package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;

public class IntLiteral extends Literal {

	private final int value;

	public IntLiteral(int n) {
		super(DataType.INTEGER);
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "IntLiteral [value=" + value + "]";
	}
	
}
