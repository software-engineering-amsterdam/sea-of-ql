package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;

public class IntLiteral extends Expr implements ReturnsMathOperands{

	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public final int getValue() {
		return this.value;
	}

}
