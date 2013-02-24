package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.DataType;

public class BooleanLiteral extends Literal {

	private final boolean value;

	public BooleanLiteral(boolean value) {
		super(DataType.BOOLEAN);
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BooleanLiteral [value=" + value + "]";
	}
	
}
