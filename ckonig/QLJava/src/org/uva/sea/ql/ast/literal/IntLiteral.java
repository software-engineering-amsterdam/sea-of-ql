package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsMathOperands;

public class IntLiteral extends Expr implements ReturnsMathOperands{

	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

}
