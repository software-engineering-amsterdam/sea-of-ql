package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.Visitor;

public class IntegerLiteral extends Literals {
	private final int value;

	public IntegerLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
