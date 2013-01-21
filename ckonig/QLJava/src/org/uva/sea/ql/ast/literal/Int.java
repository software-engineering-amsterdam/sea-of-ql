package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.math.MathOperand;

public class Int extends Expr implements MathOperand{

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

}
