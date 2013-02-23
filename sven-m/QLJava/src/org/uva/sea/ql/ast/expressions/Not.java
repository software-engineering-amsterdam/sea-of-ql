package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Not extends Unary {

	public Not(Expr op) {
		super(op);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
