package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class LEq extends Binary {

	public LEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
