package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Int extends Numeric {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

}
