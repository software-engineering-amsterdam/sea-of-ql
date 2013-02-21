package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class LT extends Binary {

	public LT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
