package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Mul extends Binary {

	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
