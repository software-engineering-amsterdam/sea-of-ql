package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class NEq extends Binary {

	public NEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
