package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Neg extends Unary {

	public Neg(Expr op) {
		super(op);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
