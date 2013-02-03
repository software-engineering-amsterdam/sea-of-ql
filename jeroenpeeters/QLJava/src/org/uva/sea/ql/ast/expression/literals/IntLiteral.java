package org.uva.sea.ql.ast.expression.literals;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Literal;

public class IntLiteral extends Literal {

	private final int value;

	public IntLiteral(int n) {
		super(DataType.INTEGER);
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
}
